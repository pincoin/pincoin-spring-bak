package kr.pincoin.api.shop.domain.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum PaymentMethod {
    BANK_TRANSFER_METHOD(0, "계좌이체/무통장입금"),
    ESCROW_METHOD(1, "에스크로(KB)"),
    PAYPAL_METHOD(2, "페이팔"),
    CREDIT_CARD_METHOD(3, "신용카드"),
    BANK_TRANSFER_PG_METHOD(4, "계좌이체(PG)"),
    VIRTUAL_ACCOUNT_METHOD(5, "가상계좌"),
    PHONE_BILL_METHOD(6, "휴대폰결제");

    private final Integer code;
    private final String description;

    PaymentMethod(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentMethod fromString(String description) {
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
