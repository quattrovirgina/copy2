package com.baby.babycareproductsshop.user.model;

import com.baby.babycareproductsshop.common.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserUpdAddressDto {
    @JsonIgnore
    private int iuser;

    @Positive
    private int iaddress;

    @NotBlank(message = Const.NOT_ALLOWED_ZIP_CODE)
    private String zipCode;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS)
    private String address;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS_DETAIL)
    private String addressDetail;
}
