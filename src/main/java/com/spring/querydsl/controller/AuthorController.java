package com.spring.querydsl.controller;

import com.spring.querydsl.entity.Author;
import com.spring.querydsl.model.request.AuthorCreateRequestDTO;
import com.spring.querydsl.model.request.AuthorSearchRequest;
import com.spring.querydsl.model.response.AuthorResponseDTO;
import com.spring.querydsl.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors(){
        List<AuthorResponseDTO> authors=authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Author>> searchAuthors(
            @RequestBody AuthorSearchRequest request,
            @PageableDefault(size = 10, sort = "authorId") Pageable pageable) {
        Page<Author> authors = authorService.searchAuthors(request, pageable);
        return ResponseEntity.ok(authors);
    }
}
