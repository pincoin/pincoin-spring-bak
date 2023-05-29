package kr.pincoin.api.user.domain.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum PhoneVerifiedStatus {
    UNVERIFIED(0, "미인증"),
    VERIFIED(1, "인증완료"),
    REVOKED(2, "인증취소");

    private final Integer code;
    private final String description;

    PhoneVerifiedStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PhoneVerifiedStatus fromString(String description) {
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
