package kr.pincoin.api.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class PhoneVerifiedStatusConverter implements AttributeConverter<PhoneVerifiedStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PhoneVerifiedStatus status) {
        if (status == null) {
            return null;
        }

        return status.getCode();
    }

    @Override
    public PhoneVerifiedStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(PhoneVerifiedStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
