package com.lighttoinfinity.indiahotel.accounts.web.api;


import com.lighttoinfinity.indiahotel.accounts.data.entity.User;
import com.lighttoinfinity.indiahotel.accounts.data.repository.UserRepository;
import com.lighttoinfinity.indiahotel.web.exception.AlreadyPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;




    @PostMapping("/register/user")
    public ResponseEntity<String> createUser(@RequestBody User user){

        if(this.userRepository.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username Already Present!!");
        }

        if(this.userRepository.findByPhone(user.getPhone()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone Already Present!!");
        }


        if(this.userRepository.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already Present!!");
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return ResponseEntity.ok("User was added Successfully");
    }

}
