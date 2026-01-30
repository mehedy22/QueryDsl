package com.spring.querydsl.respository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.querydsl.entity.Author;
import com.spring.querydsl.entity.QAuthor;
import com.spring.querydsl.model.request.AuthorSearchRequest;
import com.spring.querydsl.respository.custom.AuthorRepositoryCustom;
import com.spring.querydsl.respository.predicate.AuthorPredicate;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public Page<Author> searchAuthors(AuthorSearchRequest request, Pageable pageable) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QAuthor author = QAuthor.author;

        // Build the predicate
        BooleanBuilder predicate = AuthorPredicate.build(request, author);

        // Count total records
        Long total = queryFactory
                .select(author.count())
                .from(author)
                .where(predicate)
                .fetchOne();

        // Fetch paginated data
        List<Author> authors = queryFactory
                .selectFrom(author)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(author.authorId.desc())
                .fetch();

        return new PageImpl<>(authors, pageable, total != null ? total : 0);
    }
}