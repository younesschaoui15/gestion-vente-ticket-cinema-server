package com.ensa.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value="/")
    public String home() {
        return "<h1 style='color: orange; font-size:100px;'>Welcome today "+new Date()+"</h1>";
    }
}
