package kr.pincoin.api.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserProfileResponse extends UserResponse {
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phoneVerified")
    private Boolean phoneVerified;

    @JsonProperty("documentVerified")
    private Boolean documentVerified;

    @JsonProperty("photoId")
    private String photoId;

    @JsonProperty("card")
    private String card;

    @JsonProperty("totalOrderCount")
    private Long totalOrderCount;

    @JsonProperty("lastPurchased")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastPurchased;

    @JsonProperty("maxPrice")
    private BigDecimal maxPrice;

    @JsonProperty("averagePrice")
    private BigDecimal averagePrice;

    @JsonProperty("memo")
    private String memo;

    @JsonProperty("phoneVerifiedStatus")
    private Long phoneVerifiedStatus;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonProperty("firstPurchased")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime firstPurchased;

    @JsonProperty("totalListPrice")
    private BigDecimal totalListPrice;

    @JsonProperty("totalSellingPrice")
    private BigDecimal totalSellingPrice;

    @JsonProperty("domestic")
    private Long domestic;

    @JsonProperty("gender")
    private Long gender;

    @JsonProperty("telecom")
    private String telecom;

    @JsonProperty("notPurchasedMonths")
    private Boolean notPurchasedMonths;

    @JsonProperty("repurchased")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime repurchased;

    @JsonProperty("mileage")
    private BigDecimal mileage;

    @JsonProperty("allowOrder")
    private Boolean allowOrder;

    public UserProfileResponse(UserProfileResult result) {
        super(result.getId(),
              result.getEmail(),
              result.getUsername(),
              result.getFirstName(),
              result.getLastName(),
              result.getActive(),
              result.getLastLogin(),
              result.getDateJoined());

        this.phone = result.getPhone();
        this.address = result.getAddress();
        this.phoneVerified = result.getPhoneVerified();
        this.documentVerified = result.getDocumentVerified();
        this.photoId = result.getPhotoId();
        this.card = result.getCard();
        this.totalOrderCount = result.getTotalOrderCount();
        this.lastPurchased = result.getLastPurchased();
        this.maxPrice = result.getMaxPrice();
        this.averagePrice = result.getAveragePrice();
        this.memo = result.getMemo();
        this.phoneVerifiedStatus = result.getPhoneVerifiedStatus();
        this.dateOfBirth = result.getDateOfBirth();
        this.firstPurchased = result.getFirstPurchased();
        this.totalListPrice = result.getTotalListPrice();
        this.totalSellingPrice = result.getTotalSellingPrice();
        this.domestic = result.getDomestic();
        this.gender = result.getGender();
        this.telecom = result.getTelecom();
        this.notPurchasedMonths = result.getNotPurchasedMonths();
        this.repurchased = result.getRepurchased();
        this.mileage = result.getMileage();
        this.allowOrder = result.getAllowOrder();
    }
}
