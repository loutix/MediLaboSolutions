package com.ocr.client_service.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(WebRequest webRequest, Model model) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        model.addAttribute("timestamp", errorAttributes.get("timestamp"));
        model.addAttribute("error", errorAttributes.get("error"));
        model.addAttribute("status", errorAttributes.get("status"));
        model.addAttribute("path", errorAttributes.get("path"));
        return "error404";
    }


    public String getErrorPath() {
        return "/error404";
    }


}
