package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryQuery {
}
