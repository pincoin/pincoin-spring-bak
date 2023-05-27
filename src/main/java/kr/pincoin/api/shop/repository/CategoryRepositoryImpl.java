package kr.pincoin.api.shop.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.shop.domain.Category;
import kr.pincoin.api.shop.domain.QCategory;

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
}
