package kr.pincoin.api.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MailgunSendResult {
    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;

    public MailgunSendResult(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
