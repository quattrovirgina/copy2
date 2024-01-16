package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInsAddressDto {
    @JsonIgnore
    private int iuser;
    private String zipCode;
    private String address;
    private String addressDetail;

    public UserInsAddressDto(UserSignUpDto dto) {
        this.iuser = dto.getIuser();
        this.zipCode = dto.getZipCode();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
    }
}
