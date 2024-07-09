package com.lighttoinfinity.indiahotel.web.controller;


import com.lighttoinfinity.indiahotel.data.entity.Guest;
import com.lighttoinfinity.indiahotel.data.repository.GuestRepository;
import com.lighttoinfinity.indiahotel.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }


    @GetMapping
    public String getGuests(Model model){
        model.addAttribute("guests", this.guestRepository.findAll());
        return "guest-list";

    }


    @GetMapping("/add-guest")
    public String getGuestForm(Model model){

        return "add-guest";
    }

    @PostMapping("/add-guest")
    public String addGuest(@RequestParam("first_name") String firsName, @RequestParam("last_name") String lastName, @RequestParam("email_address") String emailAddress, @RequestParam("country") String country, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("phone_number")String phoneNumber, Model model){

        Guest guest = new Guest(firsName, lastName, emailAddress, country, address, state, phoneNumber);
        this.guestRepository.save(guest);
        model.addAttribute("message", "Guest "+ firsName +" "+ lastName+" has been successfully added");

        return "add-guest";
    }

}
