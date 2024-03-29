package kr.pincoin.api.shop.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class OrderVisibleStatusConverter implements AttributeConverter<OrderVisibleStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderVisibleStatus status) {
        if (status == null) {
            return null;
        }

        return status.getCode();
    }

    @Override
    public OrderVisibleStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(OrderVisibleStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
