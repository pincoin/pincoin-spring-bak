package kr.pincoin.api.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.user.domain.QDbRefreshToken;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static kr.pincoin.api.auth.jwt.TokenProvider.REFRESH_TOKEN_EXPIRES_IN;

public class DbRefreshTokenRepositoryImpl implements DbRefreshTokenRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public DbRefreshTokenRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public long refresh(UUID refreshToken, Long userId) {
        QDbRefreshToken dbRefreshToken = QDbRefreshToken.dbRefreshToken;

        return queryFactory.update(dbRefreshToken)
                .set(dbRefreshToken.refreshToken, refreshToken)
                .set(dbRefreshToken.expiresIn, LocalDateTime.now().plus(
                        Duration.of(REFRESH_TOKEN_EXPIRES_IN, ChronoUnit.SECONDS)))
                .where(dbRefreshToken.user.id.eq(userId))
                .execute();
    }
}
