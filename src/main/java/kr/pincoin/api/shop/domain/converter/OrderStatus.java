package kr.pincoin.api.shop.domain.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum OrderStatus {
    PAYMENT_PENDING_STATUS(0, "입금확인중"),
    PAYMENT_COMPLETED_STATUS(1, "입금완료"),
    UNDER_REVIEW_STATUS(2, "인증심사중"),
    PAYMENT_VERIFIED_STATUS(3, "입금인증완료"),
    SHIPPED_STATUS(4, "발송완료"),
    REFUND_REQUESTED_STATUS(5, "환불요청"),
    REFUND_PENDING_STATUS(6, "환불대기"),
    REFUNDED1_STATUS(6, "환불완료"),
    REFUNDED2_STATUS(6, "환불완료"),
    VOID_STATUS(6, "주문무효");

    private final Integer code;
    private final String description;

    OrderStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OrderStatus fromString(String description) {
        return Stream.of(values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
