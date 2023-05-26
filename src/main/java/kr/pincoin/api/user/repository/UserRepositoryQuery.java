package kr.pincoin.api.user.repository;

import kr.pincoin.api.user.domain.User;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryQuery {
    Optional<User> findUserByUsername(String username, Boolean active);

    Optional<User> findUserByEmail(String email, Boolean active);

    Optional<User> findUserWithDbRefreshToken(UUID refreshToken, Boolean active, LocalDateTime now);
}
