package kr.pincoin.api.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static kr.pincoin.api.auth.jwt.TokenProvider.REFRESH_TOKEN_EXPIRES_IN;


@Entity
@Table(name = "member_refreshtoken")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DbRefreshToken extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refresh_token")
    private UUID refreshToken; // 장고 마이그레이션 char(32), 자바 36바이트 (대시 포함)

    @Column(name = "expires_in")
    private LocalDateTime expiresIn;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public DbRefreshToken(@NotNull User user) {
        this.user = user;
    }

    public DbRefreshToken issueRefreshToken(UUID refreshToken) {
        this.refreshToken = refreshToken;

        this.expiresIn = LocalDateTime.now().plus(Duration.of(REFRESH_TOKEN_EXPIRES_IN, ChronoUnit.SECONDS));

        return this;
    }
}
