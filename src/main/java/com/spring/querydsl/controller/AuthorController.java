package com.spring.querydsl.controller;

import com.spring.querydsl.model.request.AuthorCreateRequestDTO;
import com.spring.querydsl.model.response.AuthorResponseDTO;
import com.spring.querydsl.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping()
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody AuthorCreateRequestDTO authorCreateRequestDTO) {
        AuthorResponseDTO authorResponseDTO = authorService.createAuthor(authorCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id){
        AuthorResponseDTO authorResponseDTO=authorService.getAuthor(id);
        return ResponseEntity.ok(authorResponseDTO);
    }

}
