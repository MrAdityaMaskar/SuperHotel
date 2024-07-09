package com.lighttoinfinity.indiahotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "reservations")
@Data
@ToString
public class Reservation {

    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guestId;

    @Column(name = "res_date")
    private Date resDate;

    public Reservation(){ super(); };

    public Reservation(Room roomId, Guest guestId, Date resDate) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.resDate = resDate;
    }
}
