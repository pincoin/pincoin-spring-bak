package kr.pincoin.api.user.repository;

import kr.pincoin.api.user.domain.User;
import kr.pincoin.api.user.dto.UserProfileResult;
import kr.pincoin.api.user.dto.UserResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryQuery {
    Optional<UserResult> findUserByUsername(String username, Boolean active);

    Optional<UserResult> findUserByEmail(String email, Boolean active);

    Optional<UserResult> findUserWithDbRefreshToken(UUID refreshToken, Boolean active, LocalDateTime now);

    Optional<UserProfileResult> findUser(Long id);

    Page<User> findUsers(Boolean active, Pageable pageable);
}
