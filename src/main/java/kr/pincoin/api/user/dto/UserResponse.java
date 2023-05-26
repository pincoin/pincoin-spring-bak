package kr.pincoin.api.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.pincoin.api.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("isActive")
    private boolean active;

    @JsonProperty("lastLogin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime lastLogin;

    @JsonProperty("dateJoined")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateJoined;

    public UserResponse(Long id,
                        String email,
                        String username,
                        String firstName,
                        String lastName,
                        boolean active,
                        LocalDateTime lastLogin,
                        LocalDateTime dateJoined) {
        this.id = id;

        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

        this.active = active;
        this.lastLogin = lastLogin;
        this.dateJoined = dateJoined;
    }

    public UserResponse(User user) {
        this(user.getId(),
             user.getEmail(),
             user.getUsername(),
             user.getFirstName(),
             user.getLastName(),
             user.getActive(),
             user.getLastLogin(),
             user.getDateJoined());
    }
}
