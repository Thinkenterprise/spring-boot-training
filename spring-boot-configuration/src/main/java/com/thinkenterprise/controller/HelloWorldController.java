package com.thinkenterprise.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hallo World";
    }
}
