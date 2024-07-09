package com.lighttoinfinity.indiahotel.accounts.web.api;


import com.lighttoinfinity.indiahotel.accounts.config.UserPrincipal;
import com.lighttoinfinity.indiahotel.accounts.data.entity.User;
import com.lighttoinfinity.indiahotel.accounts.data.repository.UserRepository;
import com.lighttoinfinity.indiahotel.accounts.service.MyUserService;
import com.lighttoinfinity.indiahotel.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AccountsApiController {

    @Autowired
    private MyUserService userService;

    @Autowired
    private final UserRepository userRepository;



    public AccountsApiController(UserRepository userRepository, MyUserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") Long id){
        Optional<User> user= this.userService.getUserById(id);

        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new UserNotFoundException("User Not found");
        }
    }



    @PostMapping
    public User createUser(@RequestBody User user) {

        return this.userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return this.userService.getAllUsers();
    }


    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return "This User is logged In : "+ userPrincipal.getUsername() + "and  User ID: "+ userPrincipal.getUserId();
    }




}
