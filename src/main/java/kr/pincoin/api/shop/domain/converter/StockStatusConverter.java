package kr.pincoin.api.shop.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class StockStatusConverter implements AttributeConverter<StockStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(StockStatus status) {
        if (status == null) {
            return null;
        }

        return status.getCode();
    }

    @Override
    public StockStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(StockStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
