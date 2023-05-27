package kr.pincoin.api.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductResponse {
    @JsonProperty("categoryId")
    private Long categoryId;

    @JsonProperty("categoryTitle")
    private String categoryTitle;

    @JsonProperty("categorySlug")
    private String categorySlug;

    @JsonProperty("categoryThumbnail")
    private String categoryThumbnail;

    @JsonProperty("categoryDescription")
    private String categoryDescription;

    @JsonProperty("categoryDescription1")
    private String categoryDescription1;

    @JsonProperty("categoryDiscountRate")
    private BigDecimal categoryDiscountRate;

    @JsonProperty("categoryPg")
    private Boolean categoryPg;

    @JsonProperty("categoryPgDiscountRate")
    private BigDecimal categoryPgDiscountRate;

    @JsonProperty("categoryNaverSearchTag")
    private String categoryNaverSearchTag;

    @JsonProperty("categoryNaverBrandName")
    private String categoryNaverBrandName;

    @JsonProperty("categoryNaverMakerName")
    private String categoryNaverMakerName;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("code")
    private String code;

    @JsonProperty("listPrice")
    private BigDecimal listPrice;

    @JsonProperty("sellingPrice")
    private BigDecimal sellingPrice;

    @JsonProperty("pg")
    private Boolean pg;

    @JsonProperty("pgSellingPrice")
    private BigDecimal pgSellingPrice;

    @JsonProperty("description")
    private String description;

    @JsonProperty("position")
    private Long position;

    @JsonProperty("status")
    private Long status;

    @JsonProperty("stockQuantity")
    private Long stockQuantity;

    @JsonProperty("stock")
    private Long stock;

    @JsonProperty("minimumStockLevel")
    private Long minimumStockLevel;

    @JsonProperty("maximumStockLevel")
    private Long maximumStockLevel;

    @JsonProperty("reviewCount")
    private Long reviewCount;

    @JsonProperty("reviewCountPg")
    private Long reviewCountPg;

    @JsonProperty("naverPartner")
    private Boolean naverPartner;

    @JsonProperty("naverPartnerTitle")
    private String naverPartnerTitle;

    @JsonProperty("naverPartnerTitlePg")
    private String naverPartnerTitlePg;

    @JsonProperty("naverAttribute")
    private String naverAttribute;

    public ProductResponse(CategoryProductResult result) {
        this.categoryId = result.getCategoryId();
        this.categoryTitle = result.getCategoryTitle();
        this.categorySlug = result.getCategorySlug();
        this.categoryThumbnail = result.getCategoryThumbnail();
        this.categoryDescription = result.getCategoryDescription();
        this.categoryDescription1 = result.getCategoryDescription1();
        this.categoryDiscountRate = result.getCategoryDiscountRate();
        this.categoryPg = result.getCategoryPg();
        this.categoryPgDiscountRate = result.getCategoryPgDiscountRate();
        this.categoryNaverSearchTag = result.getCategoryNaverSearchTag();
        this.categoryNaverBrandName = result.getCategoryNaverBrandName();
        this.categoryNaverMakerName = result.getCategoryNaverMakerName();

        this.id = result.getId();
        this.name =result.getName();
        this.subtitle = result.getSubtitle();
        this.code = result.getCode();
        this.listPrice = result.getListPrice();
        this.sellingPrice = result.getSellingPrice();
        this.pg = result.getPg();
        this.pgSellingPrice = result.getPgSellingPrice();
        this.description = result.getDescription();
        this.position = result.getPosition();
        this.status = result.getStatus();
        this.stockQuantity = result.getStockQuantity();
        this.stock = result.getStock();
        this.minimumStockLevel = result.getMinimumStockLevel();
        this.maximumStockLevel = result.getMaximumStockLevel();
        this.reviewCount = result.getReviewCount();
        this.reviewCountPg = result.getReviewCountPg();
        this.naverPartner = result.getNaverPartner();
        this.naverPartnerTitle = result.getNaverPartnerTitle();
        this.naverPartnerTitlePg = result.getNaverPartnerTitlePg();
        this.naverAttribute = result.getNaverAttribute();
    }
}
