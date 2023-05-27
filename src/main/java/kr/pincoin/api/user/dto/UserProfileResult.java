package kr.pincoin.api.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserProfileResult extends UserResult {
    private String phone;

    private String address;

    private Boolean phoneVerified;

    private Boolean documentVerified;

    private String photoId;

    private String card;

    private Long totalOrderCount;

    private LocalDateTime lastPurchased;

    private BigDecimal maxPrice;

    private BigDecimal averagePrice;

    private String memo;

    private Long phoneVerifiedStatus;

    private LocalDate dateOfBirth;

    private LocalDateTime firstPurchased;

    private BigDecimal totalListPrice;

    private BigDecimal totalSellingPrice;

    private Long domestic;

    private Long gender;

    private String telecom;

    private Boolean notPurchasedMonths;

    private LocalDateTime repurchased;

    private BigDecimal mileage;

    private Boolean allowOrder;

    public UserProfileResult(Long id,
                             String password,
                             String username,
                             String firstName,
                             String lastName,
                             String email,
                             Boolean superuser,
                             Boolean staff,
                             Boolean active,
                             LocalDateTime dateJoined,
                             LocalDateTime lastLogin,
                             String phone,
                             String address,
                             Boolean phoneVerified,
                             Boolean documentVerified,
                             String photoId,
                             String card,
                             Long totalOrderCount,
                             LocalDateTime lastPurchased,
                             BigDecimal maxPrice,
                             BigDecimal averagePrice,
                             String memo,
                             Long phoneVerifiedStatus,
                             LocalDate dateOfBirth,
                             LocalDateTime firstPurchased,
                             BigDecimal totalListPrice,
                             BigDecimal totalSellingPrice,
                             Long domestic,
                             Long gender,
                             String telecom,
                             Boolean notPurchasedMonths,
                             LocalDateTime repurchased,
                             BigDecimal mileage,
                             Boolean allowOrder) {
        super(id,
              password,
              username,
              firstName,
              lastName,
              email,
              superuser,
              staff,
              active,
              dateJoined,
              lastLogin);

        this.phone = phone;
        this.address = address;
        this.phoneVerified = phoneVerified;
        this.documentVerified = documentVerified;
        this.photoId = photoId;
        this.card = card;
        this.totalOrderCount = totalOrderCount;
        this.lastPurchased = lastPurchased;
        this.maxPrice = maxPrice;
        this.averagePrice = averagePrice;
        this.memo = memo;
        this.phoneVerifiedStatus = phoneVerifiedStatus;
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
