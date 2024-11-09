package com.example.GCS.controller;

import com.example.GCS.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 概要:クライアントからIDトークンを受け取り、検証する
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Value("${google.clientId}") // Google Client ID を .env または application.properties に保存して読み込みます。
    private String clientId;

    @Autowired
    public  AuthController(AuthService authService)
    {
        this.authService = authService;
    }







}
