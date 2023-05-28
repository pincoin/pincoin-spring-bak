package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.OrderProductVoucher;

import java.util.List;

public interface OrderProductVoucherQuery {
    List<OrderProductVoucher> findOrderProductVouchers(Long orderId, Long userId);
}
