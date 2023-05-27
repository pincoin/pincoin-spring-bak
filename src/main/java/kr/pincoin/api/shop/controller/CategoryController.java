package kr.pincoin.api.shop.controller;

import kr.pincoin.api.home.exception.ApiException;
import kr.pincoin.api.shop.dto.CategoryResponse;
import kr.pincoin.api.shop.dto.ProductResponse;
import kr.pincoin.api.shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 분류 - 목록 보기
     */
    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>>
    categoryList() {
        return ResponseEntity.ok().body(categoryService.listCategories()
                                                .stream()
                                                .map(CategoryResponse::new)
                                                .toList());
    }

    /**
     * 분류 - 상세 보기
     */
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse>
    categoryDetail(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId)
                .map(category -> ResponseEntity.ok().body(new CategoryResponse(category)))
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                                                    "분류 없음",
                                                    List.of("조회 가능한 분류가 없습니다.")));
    }

    /**
     * 분류 - 소속 상품 목록
     */
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductResponse>>
    productList(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.listProducts(categoryId)
                                                .stream()
                                                .map(ProductResponse::new)
                                                .toList());
    }
}
