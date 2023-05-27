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
}
