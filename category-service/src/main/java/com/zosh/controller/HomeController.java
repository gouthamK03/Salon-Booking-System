package com.zosh.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping
    public String HomeControllerHandler(){
        return "Welcome to category microservice of salon booking system";
    }
}
