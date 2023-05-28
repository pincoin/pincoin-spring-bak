package kr.pincoin.api.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PasswordGrantRequest {
    // Password Grant : 3자 서버 로그인 처리에 있어서는 권장하지 않음
    // https://www.oauth.com/oauth2-servers/access-tokens/password-grant/
    @JsonProperty("grantType")
    @NotNull(message = "필수 입력 필드")
    @Pattern(regexp = "password", flags = Pattern.Flag.CASE_INSENSITIVE, message = "잘못된 인가 요청")
    private String grantType;

    @JsonProperty("email")
    @NotNull(message = "필수 입력 필드")
    @NotBlank(message = "필수 입력 필드")
    private String email;

    @JsonProperty("password")
    @NotNull(message = "필수 입력 필드")
    @NotBlank(message = "필수 입력 필드")
    private String password;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("clientSecret")
    private String clientSecret;
}
