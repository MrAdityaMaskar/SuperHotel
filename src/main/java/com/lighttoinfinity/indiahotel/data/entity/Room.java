package com.lighttoinfinity.indiahotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name="rooms")
@Data
@ToString

public class Room{

    @Id
    @Column(name= "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "name")
    private String name;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "bed_info")
    private String bedInfo;

    @ElementCollection
    private List<String> imageUrls;

    public Room( String name, String roomNumber, String bedInfo, List<String> imageUrls) {

        this.name = name;
        this.roomNumber = roomNumber;
        this.bedInfo = bedInfo;
        this.imageUrls = imageUrls;
    }
    public Room(){
        super();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }



    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
