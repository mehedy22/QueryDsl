/*
package com.spring.querydsl.respository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.querydsl.respository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public abstract class BaseRepositoryImpl<T, ID>
        extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {

    protected final EntityManager em;
    protected final JPAQueryFactory queryFactory;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) {
        return findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Entity not found with id " + id));
    }
}
*/
