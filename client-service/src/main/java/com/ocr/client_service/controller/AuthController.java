package com.ocr.client_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "redirect:http://localhost:8090/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:http://localhost:8090/logout";
    }
}
