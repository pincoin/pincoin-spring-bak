package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "shop_product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "code")
    private String code;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @Column(name = "pg")
    private Boolean pg;

    @Column(name = "pg_selling_price")
    private BigDecimal pgSellingPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private Long position;

    @Column(name = "status")
    private Long status;

    @Column(name = "stock_quantity")
    private Long stockQuantity;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "minimum_stock_level")
    private Long minimumStockLevel;

    @Column(name = "maximum_stock_level")
    private Long maximumStockLevel;

    @Column(name = "review_count")
    private Long reviewCount;

    @Column(name = "review_count_pg")
    private Long reviewCountPg;

    @Column(name = "naver_partner")
    private Boolean naverPartner;

    @Column(name = "naver_partner_title")
    private String naverPartnerTitle;

    @Column(name = "naver_partner_title_pg")
    private String naverPartnerTitlePg;

    @Column(name = "naver_attribute")
    private Boolean naverAttribute;
}
