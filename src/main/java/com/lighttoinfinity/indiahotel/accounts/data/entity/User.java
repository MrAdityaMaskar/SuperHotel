package com.lighttoinfinity.indiahotel.accounts.data.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Data
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @Setter
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;


    @Setter
    @Column(name = "first_name")
    private String firstName;


    @Setter
    @Column(name = "last_name")
    private String lastName;


    @Setter
    @Column(name = "email", unique = true)
    private String email;

    @Setter
    @Column(name = "username", unique = true, nullable = false)
    private String username;


    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Setter
    @Column(name = "phone", unique = true)
    private String phone;

    @Setter
    @Column(name = "role")
    private String role;




    public User(){
        super();
    }
    public User(String firstName, String lastName, String email, String username, String password, String phone, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }
}
