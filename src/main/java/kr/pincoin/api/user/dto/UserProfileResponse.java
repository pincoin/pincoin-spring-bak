package kr.pincoin.api.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserProfileResponse extends UserResponse {
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phoneVerified")
    private Boolean phoneVerified;

    @JsonProperty("documentVerified")
    private Boolean documentVerified;

    @JsonProperty("phoneVerifiedStatus")
    private Long phoneVerifiedStatus;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonProperty("domestic")
    private Long domestic;

    @JsonProperty("gender")
    private Long gender;

    @JsonProperty("telecom")
    private String telecom;

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
        this.phoneVerifiedStatus = result.getPhoneVerifiedStatus();
        this.dateOfBirth = result.getDateOfBirth();
        this.domestic = result.getDomestic();
        this.gender = result.getGender();
        this.telecom = result.getTelecom();
    }
}
