package com.lighttoinfinity.indiahotel.accounts.service;

import com.lighttoinfinity.indiahotel.accounts.config.UserPrincipal;
import com.lighttoinfinity.indiahotel.accounts.data.entity.User;
import com.lighttoinfinity.indiahotel.accounts.data.repository.UserRepository;
import com.lighttoinfinity.indiahotel.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){

            var userObj = user.get();
            return UserPrincipal.builder().userId(userObj.getUserId()).username(userObj.getUsername()).authorities(List.of(new SimpleGrantedAuthority(userObj.getRole()))).password(userObj.getPassword()).build();

        }
        else{
            throw new UsernameNotFoundException(username);
        }


    }


    public Optional<User> getUserById(Long id){
        return this.userRepository.findById(id);
    }

    private List<String> getRoles(User user){

        if(user.getRole()==null){
            return new ArrayList<>();
        }

        return Arrays.stream(user.getRole().split(",")).toList();


    }


    public MyUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers(){

        return this.userRepository.findAll();
    }
}
