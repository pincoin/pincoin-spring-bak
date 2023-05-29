package kr.pincoin.api.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class GenderChoicesConverter implements AttributeConverter<GenderChoices, Integer> {
    @Override
    public Integer convertToDatabaseColumn(GenderChoices status) {
        if (status == null) {
            return null;
        }

        return status.getCode();
    }

    @Override
    public GenderChoices convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(GenderChoices.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
