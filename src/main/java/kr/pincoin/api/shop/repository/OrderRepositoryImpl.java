package kr.pincoin.api.shop.repository;

import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.shop.domain.Order;
import kr.pincoin.api.shop.domain.QOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Order> findOrders(Pageable pageable) {
        QOrder order = QOrder.order;

        JPAQuery<Order> contentQuery = queryFactory.select(order)
                .from(order);

        JPAQuery<Long> countQuery = queryFactory.select(Wildcard.count)
                .from(order);

        List<Order> content = contentQuery
                .orderBy(order.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }
}
