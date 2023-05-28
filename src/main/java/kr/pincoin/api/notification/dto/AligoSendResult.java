package kr.pincoin.api.notification.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AligoSendResult {
    @JsonProperty("result_code")
    private String resultCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("msg_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgId;

    @JsonProperty("success_cnt")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long successCnt;

    @JsonProperty("error_cnt")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long errorCnt;

    @JsonProperty("msg_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgType;

    public AligoSendResult(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public AligoSendResult(String resultCode,
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
