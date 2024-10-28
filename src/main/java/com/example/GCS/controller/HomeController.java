package com.example.GCS.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("name", authentication.getPrincipal().getAttributes().get("name"));
        }
        return "login";
    }
}
