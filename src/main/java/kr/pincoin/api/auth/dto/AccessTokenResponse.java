package kr.pincoin.api.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.pincoin.api.user.dto.UserResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessTokenResponse {
    // 액세스 토큰 응답
    // https://www.oauth.com/oauth2-servers/access-tokens/access-token-response/

    @JsonProperty("accessToken")
    @NotNull
    @NotBlank
    private String accessToken;

    @JsonProperty("tokenType")
    @NotNull
    @NotBlank
    private String tokenType;

    @JsonProperty("expiresIn")
    @NotNull
    private Integer expiresIn;

    @JsonProperty("refreshToken")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID refreshToken;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String scope;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    public AccessTokenResponse(@NotNull String accessToken,
                               @NotNull Integer expiresIn,
                               UUID refreshToken,
                               Long id,
                               String email,
                               String username,
                               String firstName,
                               String lastName) {
        this.tokenType = "Bearer";
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;

        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccessTokenResponse(String accessToken,
                               Integer expiresIn,
                               UUID refreshToken,
                               UserResult result) {
        this(accessToken,
             expiresIn,
             refreshToken,
             result.getId(),
             result.getEmail(),
             result.getUsername(),
             result.getFirstName(),
             result.getLastName());
    }
}
