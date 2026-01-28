package com.spring.querydsl.service;

import com.spring.querydsl.entity.Author;
import com.spring.querydsl.mapper.AuthorMapper;
import com.spring.querydsl.model.request.AuthorCreateRequestDTO;
import com.spring.querydsl.model.response.AuthorResponseDTO;
import com.spring.querydsl.respository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    public AuthorResponseDTO createAuthor(AuthorCreateRequestDTO authorCreateRequestDTO) {
        Author author = authorMapper.toEntity(authorCreateRequestDTO);
        authorRepository.save(author);
        return authorMapper.toAuthorResponse(author);
    }

    public AuthorResponseDTO getAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toAuthorResponse(author);
    }

    public List<AuthorResponseDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::toAuthorResponse).toList();
    }
}
