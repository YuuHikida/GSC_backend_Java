package com.example.GCS.controller;

import com.example.GCS.model.UserModel;
import com.example.GCS.service.UserService;
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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @Autowired
//    public UserController(UserServive userServive)
//    {
//        this.userService = userServive;
//    }

    @GetMapping
    public UserModel  GetOneUsersInformation(){
        return userService.GetOneUsersInformation();
        //return new UserModel("1","TANAKA","sample@yahoo.co.jp","23:00");
    }
}
