package kr.pincoin.api.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.pincoin.api.shop.domain.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("description")
    private String description;

    @JsonProperty("description1")
    private String description1;

    @JsonProperty("discountRate")
    private BigDecimal discountRate;

    @JsonProperty("pg")
    private Boolean pg;

    @JsonProperty("pgDiscountRate")
    private BigDecimal pgDiscountRate;

    @JsonProperty("naverSearchTag")
    private String naverSearchTag;

    @JsonProperty("naverBrandName")
    private String naverBrandName;

    @JsonProperty("naverMakerName")
    private String naverMakerName;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.slug = category.getSlug();
        this.thumbnail = category.getThumbnail();
        this.description = category.getDescription();
        this.description1 = category.getDescription1();
        this.discountRate = category.getDiscountRate();
        this.pg = category.getPg();
        this.pgDiscountRate = category.getPgDiscountRate();
        this.naverSearchTag = category.getNaverSearchTag();
        this.naverBrandName = category.getNaverBrandName();
        this.naverMakerName = category.getNaverMakerName();
    }
}
