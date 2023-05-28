package kr.pincoin.api.notification.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AligoSendResponse {
    @JsonProperty("resultCode")
    private String resultCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("msgId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgId;

    @JsonProperty("successCnt")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long successCnt;

    @JsonProperty("errorCnt")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long errorCnt;

    @JsonProperty("msgType")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgType;

    public AligoSendResponse(String resultCode,
                             String message,
                             String msgId,
                             Long successCnt,
                             Long errorCnt,
                             String msgType) {
        this.resultCode = resultCode;
        this.message = message;
        this.msgId = msgId;
        this.successCnt = successCnt;
        this.errorCnt = errorCnt;
        this.msgType = msgType;
    }
}
