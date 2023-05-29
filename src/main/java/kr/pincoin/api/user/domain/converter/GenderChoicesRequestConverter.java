package kr.pincoin.api.user.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class GenderChoicesRequestConverter implements Converter<String, GenderChoices> {
    @Override
    public GenderChoices convert(@NonNull String description) {
        return Stream.of(GenderChoices.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 성별 상태가 없습니다."));
    }
}
