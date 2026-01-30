package com.spring.querydsl.respository;

import com.spring.querydsl.entity.Author;
import com.spring.querydsl.respository.custom.AuthorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom {
}
