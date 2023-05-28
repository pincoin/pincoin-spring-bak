package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepositoryQuery {
    Page<Order> findOrders(Pageable pageable);
}
