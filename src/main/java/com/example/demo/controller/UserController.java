package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UsersService usersService;
    @GetMapping("/admin")
    public String getUser(){
        return "This is User";
    }

    @GetMapping("/public")
    public String getPublic(){
        return "This is public";
    }
    @PostMapping("/new")
    public String addNew(Users users){
//        users.setUserName("shubham");
//        users.setPassword("shubh");
//        users.setRole("ADMIN");
//        users.setActive(true);
//        users.setEmail("sjha@gmail.com");

       return usersService.addUsers(users);
    }
}
