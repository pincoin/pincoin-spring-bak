package kr.pincoin.api.shop.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderRepositoryImpl implements OrderRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
}
