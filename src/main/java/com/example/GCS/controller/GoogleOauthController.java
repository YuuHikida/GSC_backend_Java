package com.example.GCS.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
* 概要:認可を行う
* */
@RestController
public class GoogleOauthController {

    @RequestMapping("/")
    public ModelAndView root(final ModelAndView mav)
    {
        mav.setViewName("index"); // テンプレートHTML指定
        return mav;
    }
}
