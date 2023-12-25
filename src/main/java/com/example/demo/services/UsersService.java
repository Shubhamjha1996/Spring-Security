package com.example.demo.services;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private  BCryptPasswordEncoder passwordEncoder;


    public String addUsers(Users users) {
        if (users.getPassword() == null) {
            throw new IllegalArgumentException("Raw password cannot be null");
        }
        String encodedPassword = passwordEncoder.encode(users.getPassword());

        users.setPassword(encodedPassword);
        usersRepo.save(users);
        return "users added";
    }
}
