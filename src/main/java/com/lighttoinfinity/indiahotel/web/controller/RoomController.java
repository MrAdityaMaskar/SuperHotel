package com.lighttoinfinity.indiahotel.web.controller;

import com.lighttoinfinity.indiahotel.data.entity.Room;
import com.lighttoinfinity.indiahotel.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;

    }

    @GetMapping
    public String getRooms(Model model){

        model.addAttribute("rooms", this.roomRepository.findAll());
        return "room-list";

    }

    @GetMapping("/add-room")
    public String addRoom(Model model){
        model.addAttribute("room", new Room());

        return "add-room";
    }
    //Post Rooms.

    @PostMapping("/add-room")
    public String addRooom(@RequestParam("name") String name, @RequestParam("room_number") String roomNumber, @RequestParam("bed_info") String bedInfo, @RequestParam("images") List<String> imageUrls, Model model){
        System.out.println(name + " " + roomNumber + " " + bedInfo );

        Room room = new Room(name, roomNumber, bedInfo, imageUrls);
        this.roomRepository.save(room);

        model.addAttribute("message", "Room with name '"+ name + "' Added Successfully!!");

        return "add-room";
    }
}



