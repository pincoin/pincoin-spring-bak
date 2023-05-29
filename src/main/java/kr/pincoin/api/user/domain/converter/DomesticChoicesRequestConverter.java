package kr.pincoin.api.user.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class DomesticChoicesRequestConverter implements Converter<String, DomesticChoices> {
    @Override
    public DomesticChoices convert(@NonNull String description) {
        return Stream.of(DomesticChoices.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 내외국민 없습니다."));
    }
}
