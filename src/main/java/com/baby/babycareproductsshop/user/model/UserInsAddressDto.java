package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baby.babycareproductsshop.common.Const.*;

@Data
@NoArgsConstructor
public class UserInsAddressDto {
    @JsonIgnore
    private int iuser;

    @NotBlank(message = ZIP_CODE_IS_BLANK)
    private String zipCode;

    @NotBlank(message = ADDRESS_IS_BLANK)
    private String address;

    @NotBlank(message = ADDRESS_DETAIL_IS_BLANK)
    private String addressDetail;

    public UserInsAddressDto(UserSignUpDto dto) {
        this.iuser = dto.getIuser();
        this.zipCode = dto.getZipCode();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
    }
}
