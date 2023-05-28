package kr.pincoin.api.shop.dto;

import kr.pincoin.api.shop.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponse {
    private Long id;

    private UUID orderNo;

    private String fullName;

    private String userAgent;

    private String acceptLanguage;

    private String ipAddress;

    private Long paymentMethod;

    private String transactionId;

    private Long status;

    private Long visible;

    private BigDecimal totalListPrice;

    private BigDecimal totalSellingPrice;

    private String currency;

    private String message;

    private Boolean suspicious;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.orderNo = order.getOrderNo();
        this.fullName = order.getFullName();
        this.userAgent = order.getUserAgent();
        this.acceptLanguage = order.getAcceptLanguage();
        this.ipAddress = order.getIpAddress();
        this.paymentMethod = order.getPaymentMethod();
        this.transactionId = order.getTransactionId();
        this.status = order.getStatus();
        this.visible = order.getVisible();
        this.totalListPrice = order.getTotalListPrice();
        this.totalSellingPrice = order.getTotalSellingPrice();
        this.currency = order.getCurrency();
        this.message = order.getMessage();
        this.suspicious = order.getSuspicious();
    }
}
