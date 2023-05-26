package kr.pincoin.api.user.repository;

import java.util.UUID;

public interface DbRefreshTokenRepositoryQuery {
    long refresh(UUID refreshToken, Long userId);
}
