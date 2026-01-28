package com.spring.querydsl.mapper;

import com.spring.querydsl.entity.Author;
import com.spring.querydsl.model.request.AuthorCreateRequestDTO;
import com.spring.querydsl.model.response.AuthorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorResponseDTO toAuthorResponse(Author author) {
       return new AuthorResponseDTO(
               author.getAuthorId(),
               author.getName(),
               author.getEmail(),
               author.getPhone(),
               author.getAddress()
       );
    }

    public Author toEntity(AuthorCreateRequestDTO authorCreateRequestDTO) {
        Author author = new Author();
        author.setAuthorId(authorCreateRequestDTO.id());
        author.setName(authorCreateRequestDTO.name());
        author.setEmail(authorCreateRequestDTO.email());
        author.setPhone(authorCreateRequestDTO.phone());
        author.setAddress(authorCreateRequestDTO.address());
        return author;
    }
}
