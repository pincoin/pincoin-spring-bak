package kr.pincoin.api.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import kr.pincoin.api.home.domain.BaseDateTime;
import kr.pincoin.api.user.domain.converter.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member_profile")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_verified")
    private Boolean phoneVerified;

    @Column(name = "phone_verified_status")
    @NotNull
    @Convert(converter = PhoneVerifiedStatusConverter.class)
    private PhoneVerifiedStatus phoneVerifiedStatus;

    @Column(name = "document_verified")
    private Boolean documentVerified;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "card")
    private String card;

    @Column(name = "total_order_count")
    private Long totalOrderCount;

    @Column(name = "last_purchased")
    private LocalDateTime lastPurchased;

    @Column(name = "max_price")
    private BigDecimal maxPrice;

    @Column(name = "average_price")
    private BigDecimal averagePrice;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "memo")
    private String memo;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "first_purchased")
    private LocalDateTime firstPurchased;

    @Column(name = "total_list_price")
    private BigDecimal totalListPrice;

    @Column(name = "total_selling_price")
    private BigDecimal totalSellingPrice;

    @Column(name = "domestic")
    @NotNull
    @Convert(converter = DomesticChoicesConverter.class)
    private DomesticChoices domestic;

    @Column(name = "gender")
    @NotNull
    @Convert(converter = GenderChoicesConverter.class)
    private GenderChoices gender;

    @Column(name = "telecom")
    private String telecom;

    @Column(name = "not_purchased_months")
    private Boolean notPurchasedMonths;

    @Column(name = "repurchased")
    private LocalDateTime repurchased;

    @Column(name = "mileage")
    private BigDecimal mileage;

    @Column(name = "allow_order")
    private Boolean allowOrder;

    public Profile(String phone,
                   String address,
                   Boolean phoneVerified,
                   @NotNull PhoneVerifiedStatus phoneVerifiedStatus,
                   Boolean documentVerified,
                   String photoId,
                   String card,
                   Long totalOrderCount,
                   LocalDateTime lastPurchased,
                   BigDecimal maxPrice,
                   BigDecimal averagePrice,
                   @NotNull User user,
                   String memo,
                   LocalDate dateOfBirth,
                   LocalDateTime firstPurchased,
                   BigDecimal totalListPrice,
                   BigDecimal totalSellingPrice,
                   @NotNull DomesticChoices domestic,
                   @NotNull GenderChoices gender,
                   String telecom,
                   Boolean notPurchasedMonths,
                   LocalDateTime repurchased,
                   BigDecimal mileage,
                   Boolean allowOrder) {
        this.phone = phone;
        this.address = address;
        this.phoneVerified = phoneVerified;
        this.phoneVerifiedStatus = phoneVerifiedStatus;
        this.documentVerified = documentVerified;
        this.photoId = photoId;
        this.card = card;
        this.totalOrderCount = totalOrderCount;
        this.lastPurchased = lastPurchased;
        this.maxPrice = maxPrice;
        this.averagePrice = averagePrice;
        this.user = user;
        this.memo = memo;
        this.dateOfBirth = dateOfBirth;
        this.firstPurchased = firstPurchased;
        this.totalListPrice = totalListPrice;
        this.totalSellingPrice = totalSellingPrice;
        this.domestic = domestic;
        this.gender = gender;
        this.telecom = telecom;
        this.notPurchasedMonths = notPurchasedMonths;
        this.repurchased = repurchased;
        this.mileage = mileage;
        this.allowOrder = allowOrder;
    }
}
