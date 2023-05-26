package kr.pincoin.api.auth.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import kr.pincoin.api.auth.dto.AccessTokenResponse;
import kr.pincoin.api.auth.dto.PasswordGrantRequest;
import kr.pincoin.api.auth.dto.RefreshTokenRequest;
import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.user.dto.UserCreateRequest;
import kr.pincoin.api.user.dto.UserResponse;
import kr.pincoin.api.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@Slf4j
public class AuthController {
    private  final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse>
    createUser(@Valid @RequestBody UserCreateRequest request) throws DataIntegrityViolationException,
                                                                     ConstraintViolationException {
        // @Valid - JSR-303 자바 표준 스펙
        // 특정 ArgumentResolver를 통해 진행되어 "컨트롤러 메소드의 유효성 검증"만 가능
        // 유효성 검증에 실패할 경우 MethodArgumentNotValidException 예외 발생

        // @Validated -  스프링 프레임워크 지원 스펙
        // AOP를 기반으로 스프링 빈의 유효성 검증을 위해 사용, 클래에는 @Validated, 메소드에는 @Valid
        // 유효성 검증에 실패할 경우 ConstraintViolationException 예외 발생

        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AccessTokenResponse>
    authenticate(@Valid @RequestBody PasswordGrantRequest request) {
        return userService.authenticate(request)
                .map(response -> {
                    HttpHeaders responseHeaders = new HttpHeaders();
                    responseHeaders.add("Authorization", "Bearer " + response.getAccessToken());
                    return ResponseEntity.ok().headers(responseHeaders).body(response);
                })
                .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED,
                                                    "로그인 실패",
                                                    List.of("아이디 또는 비밀번호가 올바르지 않습니다.")));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AccessTokenResponse>
    refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        return userService.refresh(request)
                .map(response -> {
                    HttpHeaders responseHeaders = new HttpHeaders();
                    responseHeaders.add("Authorization", "Bearer " + response.getAccessToken());
                    return ResponseEntity.ok().headers(responseHeaders).body(response);
                })
                .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED,
                                                    "갱신 토큰 만료",
                                                    List.of("로그아웃되었습니다.")));
    }
}
