package com.example.GCS.controller;

import com.example.GCS.service.auth.TokenVerifier;

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

//    private final TokenVerifier tokenVerifier;

//    @Autowired
//    public AuthController( TokenVerifier tokenVerifier) {
//        this.tokenVerifier = tokenVerifier;
//    }

    /*
     * 概要 : フロントから受け取ったトークンを確認してデータを返す
     * 、token が JSONのボディ に含まれている場合、@RequestParam ではなく @RequestBody を使う必要がある
     */
//    @PostMapping("/authenticate")
//    public UserHomeInfoDTO authenticateAndUserName_UserEmail(@RequestBody Map<String, String> payload) throws GeneralSecurityException, IOException {
//        System.out.println("Received payload: " + payload); //dbg
//        String token = payload.get("token");
//        if (token == null || token.isEmpty()) {
//            throw new IllegalArgumentException("Token is missing or empty");
//        }
//        // トークン検証コード(Google)
//        Optional<TmpUserHomeInfoDTO> tmpUserHomeInfoDTO = tokenVerifier.GoogleVerifyToken(token);
//        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
//        //
//
//        return userHomeInfoDTO;
//    }

    /*
     * 概要 : フロントから受け取ったトークンを確認してデータを返す
     * 、token が JSONのボディ に含まれている場合、@RequestParam ではなく @RequestBody を使う必要がある
     */
//    @PostMapping("/authenticate")
//    public UserHomeInfoDTO authenticateAndUserName_UserEmail(@RequestBody AuthenticationRequest authenticationRequest) throws GeneralSecurityException, IOException {
//        return userHomeInfoDTO;
//    }

    @GetMapping("/testAuthenticate")
    public String TestGetMethod() throws GeneralSecurityException, IOException {
        System.out.println("authenticate is alive");
        return "Hello,World";
    }

}
