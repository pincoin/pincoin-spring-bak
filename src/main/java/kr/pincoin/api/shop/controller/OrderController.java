package kr.pincoin.api.shop.controller;

import kr.pincoin.api.home.dto.PageResponse;
import kr.pincoin.api.shop.domain.Order;
import kr.pincoin.api.shop.dto.OrderProductVoucherResponse;
import kr.pincoin.api.shop.dto.OrderResponse;
import kr.pincoin.api.shop.service.OrderService;
import kr.pincoin.api.user.dto.UserProfileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 주문관리 - 주문목록
     */
    @GetMapping("")
    public ResponseEntity<PageResponse<List<OrderResponse>>>
    orderList(Pageable pageable) {
        Page<Order> page = orderService.listOrders(pageable);
        return ResponseEntity.ok().body(new PageResponse<>(page.getTotalElements(),
                                                           page.getContent()
                                                                   .stream()
                                                                   .map(OrderResponse::new)
                                                                   .toList()));
    }

    /**
     * 주문관리 - 주문보기
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<UserProfileResponse>
    orderDetail(@PathVariable Long orderId) {
        return null;
    }

    /**
     * 주문관리 - 발권 상품권 목록
     */
    @GetMapping("/{orderId}/users/{userId}/vouchers")
    public ResponseEntity<List<OrderProductVoucherResponse>>
    voucherList(@PathVariable Long orderId,
                @PathVariable Long userId) {
        return ResponseEntity.ok().body(orderService.listVouchers(orderId, userId)
                                                .stream()
                                                .map(OrderProductVoucherResponse::new)
                                                .toList());
    }
}
