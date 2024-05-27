package com.ocr.client_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class clientController {


    @GetMapping()
    public String index() {
        return "Home";
    }


}
