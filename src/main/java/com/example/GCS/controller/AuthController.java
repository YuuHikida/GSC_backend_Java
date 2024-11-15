package com.example.GCS.controller;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.security.GeneralSecurityException;

/*
 * 概要:クライアントからIDトークンを受け取り、検証する
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*
     * 概要 : フロントから受け取ったトークンを確認してデータを返す
     */
    @PostMapping("/authenticate")
    public UserHomeInfoDTO authenticateAndUserName_UserEmail(@RequestParam("token") String token) throws GeneralSecurityException, IOException
    {
        // トークン検証コード
        return authService.authenticatingTheClientId(token);
    }


}
