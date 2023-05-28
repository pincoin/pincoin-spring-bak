package kr.pincoin.api.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineNotifyResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    public LineNotifyResponse(String status,
                              String message) {
        this.status = status;
        this.message = message;
    }
}
