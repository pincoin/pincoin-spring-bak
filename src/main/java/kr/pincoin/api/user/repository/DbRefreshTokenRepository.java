package kr.pincoin.api.user.repository;

import kr.pincoin.api.user.domain.DbRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbRefreshTokenRepository extends JpaRepository<DbRefreshToken, Long>, DbRefreshTokenRepositoryQuery {
}
