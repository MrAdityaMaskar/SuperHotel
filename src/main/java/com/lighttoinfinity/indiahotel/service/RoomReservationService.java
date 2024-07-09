package com.lighttoinfinity.indiahotel.service;


import com.lighttoinfinity.indiahotel.data.entity.Guest;
import com.lighttoinfinity.indiahotel.data.entity.Reservation;
import com.lighttoinfinity.indiahotel.data.entity.Room;
import com.lighttoinfinity.indiahotel.data.repository.GuestRepository;
import com.lighttoinfinity.indiahotel.data.repository.ReservationRepository;
import com.lighttoinfinity.indiahotel.data.repository.RoomRepository;
import com.lighttoinfinity.indiahotel.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;



@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;


    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }


    public List<RoomReservation> getRoomReservationsForDate(String reservationDate){
        Date date = null;

        if(StringUtils.isNotEmpty(reservationDate)){
            date = Date.valueOf(reservationDate);
            System.out.println(reservationDate);

        }else {
            date = new Date((new java.util.Date().getTime()));
        }

        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        List<Room> rooms = this.roomRepository.findAll();

        rooms.forEach(room-> {
            RoomReservation roomReservation= new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservations.put(roomReservation.getRoomId(), roomReservation);


        });

        List<Reservation> reservations = this.reservationRepository.findAllByResDate(date);



        reservations.forEach(reservation ->{
            RoomReservation roomReservation = roomReservations.get(reservation.getId());


            if(roomReservation!= null) {
                roomReservation.setReservationId(reservation.getId());
                roomReservation.setReservationDate(reservation.getResDate());
                Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId().getId());

                roomReservation.setGuestId(guest.get().getId());
                roomReservation.setFirstName(guest.get().getFirstName());
                roomReservation.setLastName(guest.get().getLastName());
            }



        });

        return roomReservations.values().stream().toList();


    }
}
