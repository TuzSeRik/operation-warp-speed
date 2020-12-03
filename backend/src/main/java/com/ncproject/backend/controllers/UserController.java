package com.ncproject.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @GetMapping("/helloThere")
    String helloThere() {
        return "This isn't endpoint you're looking for";
    }
}
