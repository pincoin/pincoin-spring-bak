package kr.pincoin.api.shop.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class AccountChoicesConverter implements AttributeConverter<AccountChoices, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AccountChoices choices) {
        if (choices == null) {
            return null;
        }

        return choices.getCode();
    }

    @Override
    public AccountChoices convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(AccountChoices.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
