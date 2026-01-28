package com.spring.querydsl.model.request;

public record AuthorCreateRequestDTO(
        Long id,
        String name,
        String email,
        String phone,
        String address
) {
}
