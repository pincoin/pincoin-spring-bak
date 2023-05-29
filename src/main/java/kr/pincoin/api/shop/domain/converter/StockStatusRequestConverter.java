package kr.pincoin.api.shop.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class StockStatusRequestConverter implements Converter<String, StockStatus> {
    @Override
    public StockStatus convert(@NonNull String description) {
        return Stream.of(StockStatus.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 주문 상태가 없습니다."));
    }
}
