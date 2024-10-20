package com.example.GCS.controller;

import com.example.GCS.model.UserModel;
import com.example.GCS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 概要:ルート
* */
@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public  String HomeCurrent()
    {
        return "Hello,World";
    }

    @GetMapping("/{gitName}")
    public UserModel  GetOneUsersInformation(@PathVariable("gitName")String gitName){
        return userService.GetOneUsersInformation(gitName);
    }
}
