package kr.pincoin.api.shop.controller;

import kr.pincoin.api.home.dto.PageResponse;
import kr.pincoin.api.shop.dto.OrderProductVoucherResponse;
import kr.pincoin.api.shop.service.OrderService;
import kr.pincoin.api.user.dto.UserProfileResponse;
import kr.pincoin.api.user.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<PageResponse<List<UserResponse>>>
    orderList(@RequestParam(name = "hidden", required = false) Boolean hidden,
              Pageable pageable) {
        return null;
    }

    /**
     * 주문관리 - 주문목록
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
