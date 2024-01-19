package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import static com.baby.babycareproductsshop.common.Const.*;

@Data
public class UserUpdAddressDto {
    @JsonIgnore
    private int iuser;

    @Positive
    private int iaddress;

    @NotBlank(message = ZIP_CODE_IS_BLANK)
    private String zipCode;

    @NotBlank(message = ADDRESS_IS_BLANK)
    private String address;

    @NotBlank(message = ADDRESS_DETAIL_IS_BLANK)
    private String addressDetail;
}
