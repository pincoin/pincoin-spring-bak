package kr.pincoin.api.shop.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.shop.domain.Category;
import kr.pincoin.api.shop.domain.QCategory;
import kr.pincoin.api.shop.domain.QProduct;
import kr.pincoin.api.shop.dto.CategoryProductResult;

import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public CategoryRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Category> findCategory(Long categoryId) {
        QCategory category = QCategory.category;

        return Optional.ofNullable(queryFactory.select(category)
                                           .from(category)
                                           .where(category.id.eq(categoryId))
                                           .fetchOne());
    }

    @Override
    public List<Category> findCategories() {
        QCategory category = QCategory.category;

        return queryFactory.select(category)
                .from(category)
                .orderBy(category.treeId.asc(),
                         category.lft.asc())
                .fetch();
    }

    @Override
    public List<CategoryProductResult> findCategoryProducts(Long categoryId) {
        QCategory category = QCategory.category;
        QProduct product = QProduct.product;

        return queryFactory.select(Projections.fields(CategoryProductResult.class,
                                                      category.id.as("categoryId"),
                                                      category.title.as("categoryTitle"),
                                                      category.slug.as("categorySlug"),
                                                      category.thumbnail.as("categoryThumbnail"),
                                                      category.description.as("categoryDescription"),
                                                      category.description1.as("categoryDescription1"),
                                                      category.discountRate.as("categoryDiscountRate"),
                                                      category.pg.as("categoryPg"),
                                                      category.pgDiscountRate.as("categoryPgDiscountRate"),
                                                      category.naverSearchTag.as("categoryNaverSearchTag"),
                                                      category.naverBrandName.as("categoryNaverBrandName"),
                                                      category.naverMakerName.as("categoryNaverMakerName"),
                                                      product.id.as("id"),
                                                      product.name.as("name"),
                                                      product.subtitle.as("subtitle"),
                                                      product.code.as("code"),
                                                      product.listPrice.as("listPrice"),
                                                      product.sellingPrice.as("sellingPrice"),
                                                      product.pg.as("pg"),
                                                      product.pgSellingPrice.as("pgSellingPrice"),
                                                      product.description.as("description"),
                                                      product.position.as("position"),
                                                      product.status.as("status"),
                                                      product.stockQuantity.as("stockQuantity"),
                                                      product.stock.as("stock"),
                                                      product.minimumStockLevel.as("minimumStockLevel"),
                                                      product.maximumStockLevel.as("maximumStockLevel"),
                                                      product.reviewCount.as("reviewCount"),
                                                      product.reviewCountPg.as("reviewCountPg"),
                                                      product.naverPartner.as("naverPartner"),
                                                      product.naverPartnerTitle.as("naverPartnerTitle"),
                                                      product.naverPartnerTitlePg.as("naverPartnerTitlePg"),
                                                      product.naverAttribute.as("naverAttribute")))
                .from(category)
                .innerJoin(product)
                .on(product.category.id.eq(category.id))
                .where(category.id.eq(categoryId))
                .fetch();
    }
}
