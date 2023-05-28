package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.OrderProductVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductVoucherRepository
        extends JpaRepository<OrderProductVoucher, Long>, OrderProductVoucherQuery {
}
