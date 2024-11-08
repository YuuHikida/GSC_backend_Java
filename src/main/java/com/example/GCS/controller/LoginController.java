//package com.example.GCS.controller;
//
//import com.example.GCS.dto.UserHomeInfoDTO;
//import com.example.GCS.service.HomeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//
//    private final HomeService homeService;
//
//    @Autowired
//    public LoginController(HomeService homeService) {
//        this.homeService = homeService;
//    }
//
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//    @GetMapping("/loginSuccess")
//    public UserHomeInfoDTO loginSuccess(OAuth2AuthenticationToken authentication, Model model) {
//        // ユーザー情報を取得
//        UserHomeInfoDTO userHomeInfoDTO = homeService.getUserInfoFromOAuth2(authentication);
//
//        // デバッグログ
//        System.out.println("User Name: " + userHomeInfoDTO.getUserName());
//        System.out.println("User Email: " + userHomeInfoDTO.getEmail());
//
//        return userHomeInfoDTO;
//    }
//
//}
