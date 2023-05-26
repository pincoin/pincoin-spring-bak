package kr.pincoin.api.auth.service;

import kr.pincoin.api.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("identity")
@Slf4j
public class IdentityService {
    public boolean isOwner(Long userId) {
        User user = getUser();

        if (!user.getId().equals(userId)) {
            log.warn("요청 리소스의 사용자 아이디 불일치: {}", userId);
            return false;
        }

        return true;
    }

    public boolean isSuperuser() {
        User user = getUser();

        if (!user.getSuperuser()) {
            log.warn("최고관리자 권한 없음: {}", user.getId());
            return false;
        }

        return true;
    }

    private static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
