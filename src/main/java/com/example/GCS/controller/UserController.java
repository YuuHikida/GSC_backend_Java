package com.example.GCS.controller;

import com.example.GCS.model.UserModel;
import com.example.GCS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserModel> getOneUsersInformation(@PathVariable("gitName") String gitName) {
        System.out.println("gitName!!!!!!!!!!!!!"+gitName);
        UserModel user = userService.GetOneUsersInformation(gitName);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK として返す
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found として返す
        }
    }

    @GetMapping("/1/{email}")
    public UserModel getOneEMail(@PathVariable("email")String email){
        UserModel userEmail = userService.getOneEmail(email);
        System.out.println(userEmail);
        return userEmail;
    }
}
