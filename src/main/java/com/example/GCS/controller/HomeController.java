package com.example.GCS.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/root")
    public String home(OAuth2AuthenticationToken authentication) {
        return "Hello, " + authentication.getPrincipal().getAttributes().get("name");
    }
}