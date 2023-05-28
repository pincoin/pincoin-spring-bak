package kr.pincoin.api.shop.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class OrderVisibleConverter implements AttributeConverter<OrderVisible, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderVisible status) {
        if (status == null) {
            return null;
        }

        return status.getCode();
    }

    @Override
    public OrderVisible convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(OrderVisible.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
