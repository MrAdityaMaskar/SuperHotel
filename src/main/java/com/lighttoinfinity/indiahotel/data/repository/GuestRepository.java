package com.lighttoinfinity.indiahotel.data.repository;

import com.lighttoinfinity.indiahotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findAllById(int id);



}
