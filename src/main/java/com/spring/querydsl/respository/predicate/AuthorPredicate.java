package com.spring.querydsl.respository.predicate;

import com.querydsl.core.BooleanBuilder;
import com.spring.querydsl.entity.QAuthor;
import com.spring.querydsl.model.request.AuthorSearchRequest;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class AuthorPredicate {

    public static BooleanBuilder build(AuthorSearchRequest request, QAuthor qAuthor) {
        BooleanBuilder builder = new BooleanBuilder();

        // Get keyword from request
        String keyword = request.keyword();

        // If keyword is null or empty, return empty builder (returns all records)
        if (keyword == null || keyword.trim().isEmpty()) {
            return builder;
        }

        // Build OR conditions for universal search
        BooleanBuilder keywordBuilder = new BooleanBuilder();
        keywordBuilder.or(qAuthor.name.containsIgnoreCase(keyword))
                .or(qAuthor.email.containsIgnoreCase(keyword))
                .or(qAuthor.phone.containsIgnoreCase(keyword))
                .or(qAuthor.address.containsIgnoreCase(keyword));

        builder.and(keywordBuilder);

        return builder;
    }
}