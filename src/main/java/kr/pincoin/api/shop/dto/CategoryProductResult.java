package kr.pincoin.api.shop.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CategoryProductResult {
    private Long categoryId;

    private String categoryTitle;

    private String categorySlug;

    private String categoryThumbnail;

    private String categoryDescription;

    private String categoryDescription1;

    private BigDecimal categoryDiscountRate;

    private Boolean categoryPg;

    private BigDecimal categoryPgDiscountRate;

    private String categoryNaverSearchTag;

    private String categoryNaverBrandName;

    private String categoryNaverMakerName;

    private Long id;

    private String name;

    private String subtitle;

    private String code;

    private BigDecimal listPrice;

    private BigDecimal sellingPrice;

    private Boolean pg;

    private BigDecimal pgSellingPrice;

    private String description;

    private Long position;

    private Long status;

    private Long stockQuantity;

    private Long stock;

    private Long minimumStockLevel;

    private Long maximumStockLevel;

    private Long reviewCount;

    private Long reviewCountPg;

    private Boolean naverPartner;

    private String naverPartnerTitle;

    private String naverPartnerTitlePg;

    private String naverAttribute;
}
