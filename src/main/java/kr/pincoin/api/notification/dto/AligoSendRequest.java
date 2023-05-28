package kr.pincoin.api.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AligoSendRequest {
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("message")
    private String message;

    public AligoSendRequest(String phone, String message) {
        this.phone = phone;
        this.message = message;
    }
}
