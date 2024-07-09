package com.lighttoinfinity.indiahotel.accounts.data.repository;

import com.lighttoinfinity.indiahotel.accounts.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findById(long id);
    Optional<User> findByUsername(String username);


    Optional<User> findByPhone(String phone);

    Optional<User> findByEmail(String email);

}
