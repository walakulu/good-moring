package com.demo.microservice.goodmorning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/morning/message")
    public ResponseEntity<String> getWelcomeMessage() {
        return ResponseEntity.ok("Good Morning!");
    }
}
