package kr.pincoin.api.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class DomesticChoicesConverter implements AttributeConverter<DomesticChoices, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DomesticChoices choices) {
        if (choices == null) {
            return null;
        }

        return choices.getCode();
    }

    @Override
    public DomesticChoices convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DomesticChoices.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
