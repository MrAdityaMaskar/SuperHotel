package com.lighttoinfinity.indiahotel.web.api;


import com.lighttoinfinity.indiahotel.data.entity.Guest;
import com.lighttoinfinity.indiahotel.data.repository.GuestRepository;
import com.lighttoinfinity.indiahotel.web.exception.BadRequestException;
import com.lighttoinfinity.indiahotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestApiController {
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllGuests(){return this.guestRepository.findAll();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest){
        return this.guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id){
        Optional<Guest> guest= this.guestRepository.findById(id);
        if(guest.isEmpty()){
            throw new NotFoundException("Guest not found with id "+ id);
        }
        return guest.get();
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id")long id, @RequestBody Guest guest){
        if(id!=guest.getId()){
            throw new BadRequestException("Id and the path dosen't match body!");

        }
        return this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id")long id){
        this.guestRepository.deleteById(id);
    }




}
