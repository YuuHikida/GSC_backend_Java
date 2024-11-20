package com.example.GCS.controller;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Map;

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
     * 、token が JSONのボディ に含まれている場合、@RequestParam ではなく @RequestBody を使う必要がある
     */
    @PostMapping("/authenticate")
    public UserHomeInfoDTO authenticateAndUserName_UserEmail(@RequestBody Map<String, String> payload) throws GeneralSecurityException, IOException
    {
        String token = payload.get("token");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is missing or empty");
        }
        // トークン検証コード
        return authService.authenticatingTheClientId(token);
    }


}
