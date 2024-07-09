package com.lighttoinfinity.indiahotel.data.repository;

import com.lighttoinfinity.indiahotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    List<Reservation> findAllByResDate(Date date);
}
