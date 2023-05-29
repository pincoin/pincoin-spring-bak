package kr.pincoin.api.shop.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class AccountChoicesRequestConverter implements Converter<String, AccountChoices> {
    @Override
    public AccountChoices convert(@NonNull String description) {
        return Stream.of(AccountChoices.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 은행이 없습니다."));
    }
}
