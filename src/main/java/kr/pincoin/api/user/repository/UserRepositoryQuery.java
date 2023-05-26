package kr.pincoin.api.user.repository;

import kr.pincoin.api.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryQuery {
    Optional<User> findUserByUsername(String username, Boolean active);

    Optional<User> findUserByEmail(String email, Boolean active);

    Optional<User> findUserWithDbRefreshToken(UUID refreshToken, Boolean active, LocalDateTime now);

    Page<User> findUsers(Boolean active, Pageable pageable);
}
