package com.spring.querydsl.model.response;

public record AuthorResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String address
) {

}
