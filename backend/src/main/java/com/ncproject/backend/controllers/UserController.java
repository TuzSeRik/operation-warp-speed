package com.ncproject.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    @GetMapping("/register")
    public String register(String message) {
        return "Hello, world!";
    }
}
