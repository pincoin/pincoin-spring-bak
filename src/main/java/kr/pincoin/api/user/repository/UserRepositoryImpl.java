package kr.pincoin.api.user.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pincoin.api.user.domain.*;
import kr.pincoin.api.user.dto.UserProfileResult;
import kr.pincoin.api.user.dto.UserResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<UserResult> findUserByUsername(String username, Boolean active) {
        QUser user = QUser.user;
        QEmailAddress emailAddress = QEmailAddress.emailAddress;

        return Optional.ofNullable(queryFactory
                                           .select(Projections.fields(UserResult.class,
                                                                      user.id.as("id"),
                                                                      user.password.as("password"),
                                                                      user.username.as("username"),
                                                                      user.firstName.as("firstName"),
                                                                      user.lastName.as("lastName"),
                                                                      emailAddress.email.as("email"),
                                                                      user.superuser.as("superuser"),
                                                                      user.staff.as("staff"),
                                                                      user.active.as("active"),
                                                                      user.dateJoined.as("dateJoined"),
                                                                      user.lastLogin.as("lastLogin")))
                                           .from(user)
                                           .innerJoin(emailAddress)
                                           .on(emailAddress.user.id.eq(user.id))
                                           .where(user.username.eq(username),
                                                  emailAddress.primary.isTrue(),
                                                  emailAddress.verified.isTrue(),
                                                  user.active.isTrue())
                                           .fetchOne());
    }

    @Override
    public Optional<UserResult> findUserByEmail(String email, Boolean active) {
        QUser user = QUser.user;
        QEmailAddress emailAddress = QEmailAddress.emailAddress;

        return Optional.ofNullable(queryFactory
                                           .select(Projections.fields(UserResult.class,
                                                                      user.id.as("id"),
                                                                      user.password.as("password"),
                                                                      user.username.as("username"),
                                                                      user.firstName.as("firstName"),
                                                                      user.lastName.as("lastName"),
                                                                      emailAddress.email.as("email"),
                                                                      user.superuser.as("superuser"),
                                                                      user.staff.as("staff"),
                                                                      user.active.as("active"),
                                                                      user.dateJoined.as("dateJoined"),
                                                                      user.lastLogin.as("lastLogin")))
                                           .from(user)
                                           .innerJoin(emailAddress)
                                           .on(emailAddress.user.id.eq(user.id))
                                           .where(emailAddress.email.eq(email),
                                                  emailAddress.primary.isTrue(),
                                                  emailAddress.verified.isTrue(),
                                                  user.active.isTrue())
                                           .fetchOne());
    }

    @Override
    public Optional<UserResult> findUserWithDbRefreshToken(UUID refreshToken, Boolean active, LocalDateTime now) {
        QUser user = QUser.user;
        QEmailAddress emailAddress = QEmailAddress.emailAddress;
        QDbRefreshToken dbRefreshToken = QDbRefreshToken.dbRefreshToken;

        JPAQuery<UserResult> contentQuery = queryFactory
                .select(Projections.fields(UserResult.class,
                                           user.id.as("id"),
                                           user.password.as("password"),
                                           user.username.as("username"),
                                           user.firstName.as("firstName"),
                                           user.lastName.as("lastName"),
                                           emailAddress.email.as("email"),
                                           user.superuser.as("superuser"),
                                           user.staff.as("staff"),
                                           user.active.as("active"),
                                           user.dateJoined.as("dateJoined"),
                                           user.lastLogin.as("lastLogin")))
                .from(user)
                .innerJoin(emailAddress)
                .on(emailAddress.user.id.eq(user.id))
                .innerJoin(dbRefreshToken)
                .on(dbRefreshToken.user.id.eq(user.id))
                .where(emailAddress.primary.isTrue(),
                       emailAddress.verified.isTrue(),
                       user.active.isTrue());

        if (active != null) {
            contentQuery = contentQuery.where(user.active.eq(active));
        }

        return Optional.ofNullable(contentQuery.where(dbRefreshToken.refreshToken.eq(refreshToken),
                                                      dbRefreshToken.expiresIn.gt(now))
                                           .fetchOne());
    }

    @Override
    public Optional<UserProfileResult> findUser(Long id) {
        QUser user = QUser.user;
        QEmailAddress emailAddress = QEmailAddress.emailAddress;
        QProfile profile = QProfile.profile;

        return Optional
                .ofNullable(queryFactory
                                    .select(Projections
                                                    .fields(UserProfileResult.class,
                                                            user.id.as("id"),
                                                            user.password.as("password"),
                                                            user.username.as("username"),
                                                            user.firstName.as("firstName"),
                                                            user.lastName.as("lastName"),
                                                            emailAddress.email.as("email"),
                                                            user.superuser.as("superuser"),
                                                            user.staff.as("staff"),
                                                            user.active.as("active"),
                                                            user.dateJoined.as("dateJoined"),
                                                            user.lastLogin.as("lastLogin"),
                                                            profile.phone.as("phone"),
                                                            profile.address.as("address"),
                                                            profile.phoneVerified.as("phoneVerified"),
                                                            profile.documentVerified.as("documentVerified"),
                                                            profile.photoId.as("photoId"),
                                                            profile.card.as("card"),
                                                            profile.totalOrderCount.as("totalOrderCount"),
                                                            profile.lastPurchased.as("lastPurchased"),
                                                            profile.maxPrice.as("maxPrice"),
                                                            profile.averagePrice.as("averagePrice"),
                                                            profile.memo.as("memo"),
                                                            profile.phoneVerifiedStatus.as("phoneVerifiedStatus"),
                                                            profile.dateOfBirth.as("dateOfBirth"),
                                                            profile.firstPurchased.as("firstPurchased"),
                                                            profile.totalListPrice.as("totalListPrice"),
                                                            profile.totalSellingPrice.as("totalSellingPrice"),
                                                            profile.domestic.as("domestic"),
                                                            profile.gender.as("gender"),
                                                            profile.telecom.as("telecom"),
                                                            profile.notPurchasedMonths.as("notPurchasedMonths"),
                                                            profile.repurchased.as("repurchased"),
                                                            profile.mileage.as("mileage"),
                                                            profile.allowOrder.as("allowOrder")))
                                    .from(user)
                                    .innerJoin(emailAddress)
                                    .on(emailAddress.user.id.eq(user.id))
                                    .innerJoin(profile)
                                    .on(profile.user.id.eq(user.id))
                                    .where(user.id.eq(id),
                                           emailAddress.primary.isTrue(),
                                           emailAddress.verified.isTrue(),
                                           user.active.isTrue())
                                    .fetchOne());
    }

    @Override
    public Page<User> findUsers(Boolean active, Pageable pageable) {
        QUser user = QUser.user;

        JPAQuery<User> contentQuery = queryFactory.select(user)
                .from(user);

        JPAQuery<Long> countQuery = queryFactory.select(Wildcard.count)
                .from(user);

        if (active != null) {
            contentQuery = contentQuery.where(user.active.eq(active));
            countQuery = countQuery.where(user.active.eq(active));
        }

        List<User> content = contentQuery
                .orderBy(user.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }
}
