package kr.pincoin.api.user.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class PhoneVerifiedStatusRequestConverter implements Converter<String, PhoneVerifiedStatus> {
    @Override
    public PhoneVerifiedStatus convert(@NonNull String description) {
        return Stream.of(PhoneVerifiedStatus.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 휴대폰인증 상태가 없습니다."));
    }
}
