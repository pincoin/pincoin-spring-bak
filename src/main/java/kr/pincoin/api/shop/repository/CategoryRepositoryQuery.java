package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.Category;
import kr.pincoin.api.shop.dto.CategoryProductResult;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryQuery {
    Optional<Category> findCategory(Long categoryId);

    List<Category> findCategories(Boolean pg);

    List<CategoryProductResult> findCategoryProducts(Long categoryId);
}
