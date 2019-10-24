package com.thoughtworks.springboottutorial.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public ResponseEntity create() {
        return ResponseEntity.status(201).build();
    }
}