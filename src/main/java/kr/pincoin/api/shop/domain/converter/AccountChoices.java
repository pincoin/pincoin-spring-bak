package kr.pincoin.api.shop.domain.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum AccountChoices {
    KB(0, "국민은행"),
    NH(1, "농협은행"),
    SHINHAN(2, "신한은행"),
    WOORI(3, "우리은행"),
    IBK(4, "기업은행"),
    PAYPAL(5, "페이팔");

    private final Integer code;
    private final String description;

    AccountChoices(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static AccountChoices fromString(String description) {
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
