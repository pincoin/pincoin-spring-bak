package kr.pincoin.api.auth.jwt;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Slf4j
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void
    handle(HttpServletRequest request,
           HttpServletResponse response,
           AccessDeniedException accessDeniedException) throws IOException {
        // 403 Forbidden
        // 서버가 요청을 이해했으나 권한이 없어 요청이 거부됨
        // 클라이언트가 요청에 대한 권한이 없어 요청을 정상적으로 처리할 수 없다.
        // 예: 로그인이 되었으나 다른 사용자의 마이페이지 접근 요청 시

        // Postman 등에서 Bearer 헤더 없이 보낼 경우 FORBIDDEN 되지만 헤더 자체가 없기 때문에 에러 메시지는 확인할 수 없음
        log.warn(accessDeniedException.getLocalizedMessage());
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}