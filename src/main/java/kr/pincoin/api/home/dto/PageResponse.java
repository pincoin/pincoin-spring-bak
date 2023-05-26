package kr.pincoin.api.home.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PageResponse<T> {
    @JsonProperty("total")
    private Long totalElements;

    @JsonProperty("content")
    private T content;

    public PageResponse(Long totalElements, T content) {
        this.totalElements = totalElements;
        this.content = content;
    }
}