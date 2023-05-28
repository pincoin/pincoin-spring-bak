package kr.pincoin.api.shop.service;

import kr.pincoin.api.shop.domain.Category;
import kr.pincoin.api.shop.dto.CategoryProductResult;
import kr.pincoin.api.shop.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * 분류 - 목록 보기
     */
    @Transactional
    public List<Category>
    listCategories(Boolean pg) {
        return categoryRepository.findCategories(pg);
    }

    /**
     * 분류 - 상세 보기
     */
    @Transactional
    public Optional<Category>
    getCategory(Long categoryId) {
        return categoryRepository.findCategory(categoryId);
    }

    /**
     * 분류 - 상품 목록 보기
     */
    @Transactional
    public List<CategoryProductResult>
    listProducts(Long categoryId) {
        return categoryRepository.findCategoryProducts(categoryId);
    }
}
