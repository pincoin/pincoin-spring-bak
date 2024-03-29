package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "shop_category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name = "description1")
    private String description1;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Column(name = "pg")
    private Boolean pg;

    @Column(name = "pg_discount_rate")
    private BigDecimal pgDiscountRate;

    @Column(name = "naver_search_tag")
    private String naverSearchTag;

    @Column(name = "naver_brand_name")
    private String naverBrandName;

    @Column(name = "naver_maker_name")
    private String naverMakerName;

    @Column(name = "lft")
    private Long lft;

    @Column(name = "rght")
    private Long rght;

    @Column(name = "tree_id")
    private Long treeId;

    @Column(name = "level")
    private Long level;
}
