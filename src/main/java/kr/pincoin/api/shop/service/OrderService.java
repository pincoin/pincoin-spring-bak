package kr.pincoin.api.shop.service;

import kr.pincoin.api.shop.domain.OrderProductVoucher;
import kr.pincoin.api.shop.repository.OrderProductVoucherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderService {
    private final OrderProductVoucherRepository orderProductVoucherRepository;

    public OrderService(OrderProductVoucherRepository orderProductVoucherRepository) {
        this.orderProductVoucherRepository = orderProductVoucherRepository;
    }

    @Transactional
    @PreAuthorize("isAuthenticated() and @identity.isSuperuser() or @identity.isOwner(#userId)")
    public List<OrderProductVoucher>
    listVouchers(Long orderId, Long userId) {
        return orderProductVoucherRepository.findOrderProductVouchers(orderId, userId);
    }
}
