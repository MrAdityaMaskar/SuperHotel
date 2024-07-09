package com.lighttoinfinity.indiahotel.data.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name= "Guests")
@Data
//@ToString
public class Guest {

    @Getter
    @Id
    @Column(name= "guest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Column(name = "email_address")
    private String emailAddress;

    @Getter
    @Column(name = "country")
    private String country;

    @Getter
    @Column(name="address")
    private String address;

    @Getter
    @Column(name = "state")
    private String state;

    @Column(name = "phone_number")
    private String phoneNumber;


    public Guest(String firstName, String lastName, String emailAddress, String country, String address, String state, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.country = country;
        this.address = address;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public Guest(){ super(); };
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phoneNumber;
    }
}
