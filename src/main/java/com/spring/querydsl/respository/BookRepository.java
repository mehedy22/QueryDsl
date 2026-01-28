package com.spring.querydsl.respository;

import com.spring.querydsl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
