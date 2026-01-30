package com.spring.querydsl.respository.custom;

import com.spring.querydsl.entity.Author;
import com.spring.querydsl.model.request.AuthorSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorRepositoryCustom {
    Page<Author> searchAuthors(AuthorSearchRequest keyword, Pageable pageable);

}
