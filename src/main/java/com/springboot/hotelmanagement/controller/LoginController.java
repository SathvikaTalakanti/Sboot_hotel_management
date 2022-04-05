package com.springboot.hotelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping("/")
public class LoginController {
    @GetMapping("/login")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }


}