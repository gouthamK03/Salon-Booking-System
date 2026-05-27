package com.zosh.booking_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String homeController(){
        return "welcome to the booking service of the salon-booking-system";
    }
}
