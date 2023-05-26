package kr.pincoin.api.user.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.user.domain.QDbRefreshToken;
import kr.pincoin.api.user.domain.QUser;
import kr.pincoin.api.user.domain.User;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<User> findUserByUsername(String username, Boolean active) {
        QUser user = QUser.user;

        return Optional.ofNullable(queryFactory.select(user)
                                           .from(user)
                                           .where(user.username.eq(username),
                                                  user.active.isTrue())
                                           .fetchOne());
    }

    @Override
    public Optional<User> findUserByEmail(String email, Boolean active) {
        QUser user = QUser.user;

        return Optional.ofNullable(queryFactory.select(user)
                                           .from(user)
                                           .where(user.email.eq(email),
                                                  user.active.isTrue())
                                           .fetchOne());
    }

    @Override
    public Optional<User> findUserWithDbRefreshToken(UUID refreshToken, Boolean active, LocalDateTime now) {
        QUser user = QUser.user;
        QDbRefreshToken dbRefreshToken = QDbRefreshToken.dbRefreshToken;

        JPAQuery<User> contentQuery = queryFactory
                .select(user)
                .from(user)
                .join(dbRefreshToken)
                .on(dbRefreshToken.user.id.eq(user.id))
                .fetchJoin();

        if (active != null) {
            contentQuery = contentQuery.where(user.active.eq(active));
        }

        return Optional.ofNullable(contentQuery.where(dbRefreshToken.refreshToken.eq(refreshToken),
                                                      dbRefreshToken.expiresIn.gt(now))
                                           .fetchOne());
    }
}
