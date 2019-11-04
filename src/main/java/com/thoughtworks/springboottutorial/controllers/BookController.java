package com.thoughtworks.springboottutorial.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public ResponseEntity create(UriComponentsBuilder uriComponentsBuilder) {
        UriComponents uriComponents =
                uriComponentsBuilder.path("books/{id}").buildAndExpand("id1");
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}