package kr.pincoin.api.shop.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.shop.domain.*;
import kr.pincoin.api.user.domain.QUser;

import java.util.List;

public class OrderProductVoucherRepositoryImpl implements OrderProductVoucherQuery {
    private final JPAQueryFactory queryFactory;

    public OrderProductVoucherRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<OrderProductVoucher> findOrderProductVouchers(Long orderId, Long userId) {
        QOrderProductVoucher orderProductVoucher = QOrderProductVoucher.orderProductVoucher;
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        QVoucher voucher = QVoucher.voucher;
        QOrder order = QOrder.order;
        QUser user = QUser.user;

        JPAQuery<OrderProductVoucher> contentQuery = queryFactory.select(orderProductVoucher)
                .from(orderProductVoucher)
                .innerJoin(orderProductVoucher.voucher, voucher)
                .fetchJoin()
                .innerJoin(orderProductVoucher.orderProduct, orderProduct)
                .fetchJoin()
                .innerJoin(orderProduct.order, order)
                .innerJoin(order.user, user);

        contentQuery = contentQuery.where(user.id.eq(userId),
                                          order.id.eq(orderId));

        return contentQuery.fetch();
    }
}
