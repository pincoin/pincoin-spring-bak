package kr.pincoin.api.user.service;

import jakarta.validation.ConstraintViolationException;
import kr.pincoin.api.auth.dto.AccessTokenResponse;
import kr.pincoin.api.auth.dto.PasswordGrantRequest;
import kr.pincoin.api.auth.dto.RefreshTokenRequest;
import kr.pincoin.api.auth.jwt.TokenProvider;
import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.user.domain.DbRefreshToken;
import kr.pincoin.api.user.domain.User;
import kr.pincoin.api.user.dto.UserCreateRequest;
import kr.pincoin.api.user.dto.UserResponse;
import kr.pincoin.api.user.repository.DbRefreshTokenRepository;
import kr.pincoin.api.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static kr.pincoin.api.auth.jwt.TokenProvider.ACCESS_TOKEN_EXPIRES_IN;

@Service
@Slf4j
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    private final UserRepository userRepository;

    private final DbRefreshTokenRepository dbRefreshTokenRepository;

    public UserService(PasswordEncoder passwordEncoder,
                       TokenProvider tokenProvider,
                       UserRepository userRepository,
                       DbRefreshTokenRepository dbRefreshTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.dbRefreshTokenRepository = dbRefreshTokenRepository;
    }

    @Transactional
    public Optional<AccessTokenResponse>
    authenticate(PasswordGrantRequest request) {
        return userRepository.findUserByEmail(request.getEmail(), true)
                .map(user -> {
                    AccessTokenResponse response = null;
                    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        response = getAccessTokenResponse(user);
                    }
                    return Optional.ofNullable(response);
                })
                .orElseGet(Optional::empty);
    }

    @Transactional
    public Optional<AccessTokenResponse>
    refresh(RefreshTokenRequest request) {
        return userRepository.findUserWithDbRefreshToken(request.getRefreshToken(), true, LocalDateTime.now())
                .map(this::getAccessTokenResponse);
    }

    @Transactional
    public UserResponse
    createUser(UserCreateRequest request) throws DataIntegrityViolationException,
                                                 ConstraintViolationException {
        // 프론트엔드 체크 항목
        // 중복회원검사
        // 본인인증: 휴대폰인증, 이메일인증
        // 약관동의 (필수는 디비 저장 안 하고 옵션 사항만 저장)

        // 1. 사용자 저장
        User user = userRepository.save(new User(request.getUsername(),
                                                 passwordEncoder.encode(request.getPassword()),
                                                 request.getFirstName(),
                                                 request.getLastName(),
                                                 request.getEmail())
                                                .activate());

        // 2. 리프레시 토큰 디비 저장을 위한 빈 레코드 추가
        dbRefreshTokenRepository.save(new DbRefreshToken(user));

        return new UserResponse(user);
    }

    private AccessTokenResponse getAccessTokenResponse(User user) {
        // 1. 액세스 토큰 생성 (디비 저장 안 함)
        String accessToken = tokenProvider.createAccessToken(user.getUsername(), user.getId());

        // 2. 리프레시 토큰 생성 (디비 저장)
        UUID refreshToken = tokenProvider.createRefreshToken();

        if (dbRefreshTokenRepository.refresh(refreshToken, user.getId()) != 1) {
            throw new ApiException(HttpStatus.CONFLICT,
                                   "갱신 토큰 생성 실패",
                                   List.of("갱신 토큰 테이블 레코드가 존재하지 않습니다."));
        }

        return new AccessTokenResponse(accessToken,
                                       ACCESS_TOKEN_EXPIRES_IN,
                                       refreshToken,
                                       user);
    }
}
