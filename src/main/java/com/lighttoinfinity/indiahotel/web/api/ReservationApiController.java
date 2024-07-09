package com.lighttoinfinity.indiahotel.web.api;


import com.lighttoinfinity.indiahotel.data.entity.Reservation;
import com.lighttoinfinity.indiahotel.data.repository.ReservationRepository;
import com.lighttoinfinity.indiahotel.web.exception.BadRequestException;
import com.lighttoinfinity.indiahotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }


    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value = "date",required = false)String dateString){
        if(StringUtils.isNotBlank(dateString)){
            Date date = new Date(new java.util.Date().getTime());
            return this.reservationRepository.findAllByResDate(date);
        }
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getResById(@PathVariable("id")long id){

        Optional<Reservation> reservations= this.reservationRepository.findById(id);
        if(reservations.isEmpty()){
            throw new NotFoundException("No reservation found with id "+ id);
        }
        return reservations;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation){
        return this.reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateRoom(@PathVariable("id")long id, @RequestBody Reservation reservation){
        if(id!= reservation.getId()){
            throw new BadRequestException("Date on path Doesn't Match");
        }
        return this.reservationRepository.save(reservation);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable("id")long id){
        Reservation reservation = this.reservationRepository.getReferenceById(id);
        this.reservationRepository.delete(reservation);
    }



}
