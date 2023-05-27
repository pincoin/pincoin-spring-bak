package kr.pincoin.api.shop.repository;

import kr.pincoin.api.shop.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryQuery {
    Optional<Category> findCategory(Long categoryId);

    List<Category> findCategories();
}
