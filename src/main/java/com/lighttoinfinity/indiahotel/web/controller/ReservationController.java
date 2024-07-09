package com.lighttoinfinity.indiahotel.web.controller;

import com.lighttoinfinity.indiahotel.data.entity.Guest;
import com.lighttoinfinity.indiahotel.data.entity.Reservation;
import com.lighttoinfinity.indiahotel.data.entity.Room;
import com.lighttoinfinity.indiahotel.data.repository.GuestRepository;
import com.lighttoinfinity.indiahotel.data.repository.ReservationRepository;
import com.lighttoinfinity.indiahotel.data.repository.RoomRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationController(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository){
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }




    @GetMapping
    public String getReservationForm(Model model){

        List<Room> allRooms = this.roomRepository.findAll();
        List<Guest> allGuests = this.guestRepository.findAll();

        model.addAttribute("rooms", allRooms );
        model.addAttribute("guests", allGuests);


        return "create-reservation";
    }



    @PostMapping
    public String addReservations(@RequestParam("room") long roomId, @RequestParam("guest") long guestID, @RequestParam(value = "res_date") String resDateString){
        Date date = new Date();

        if(StringUtils.isNotBlank(resDateString)){
            try{
                SimpleDateFormat format = new SimpleDateFormat(("yyy-MM-dd"));
                date = format.parse(resDateString);

            }catch(Exception e){
                //do nothing
            }

        }

        java.sql.Date sql_date = java.sql.Date.valueOf(resDateString);
        Optional<Room> room = this.roomRepository.findById(roomId);
        Optional<Guest> guest = this.guestRepository.findById(guestID);
        Reservation reservation = new Reservation(room.get(), guest.get(), sql_date);

        this.reservationRepository.save(reservation);


        return "create-reservation";
    }

}
