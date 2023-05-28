package kr.pincoin.api.shop.domain.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;


public class OrderVisibleRequestConverter implements Converter<String, OrderVisible> {
    @Override
    public OrderVisible convert(@NonNull String description) {
        return Stream.of(OrderVisible.values())
                .filter(c -> c.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 주문 상태가 없습니다."));
    }
}
