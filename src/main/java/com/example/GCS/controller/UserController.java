package com.example.GCS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 概要:ルート
* */
@RestController
@RequestMapping("/")
public class UserController {
    //service
    //private final UserService userService;

//    @Autowired
//    public UserController(UserServive userServive)
//    {
//        this.userService = userServive;
//    }

    @GetMapping
    public String  UserHomeInfo(){
        return "hello";
    }
}
