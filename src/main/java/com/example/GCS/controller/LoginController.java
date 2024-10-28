package com.example.GCS.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginSuccess")
    public String loginSuccess(OAuth2AuthenticationToken authentication, Model model) {
        // ユーザー情報を取得
        String name = authentication.getPrincipal().getAttributes().get("name").toString();
        String email = authentication.getPrincipal().getAttributes().get("email").toString();

        // デバッグログ
        System.out.println("User Name: " + name);
        System.out.println("User Email: " + email);

        // モデルに追加
        model.addAttribute("name", name);
        model.addAttribute("email", email);

        System.out.println(authentication.getPrincipal().getAttributes());

        return "home";
    }

}
