package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserUpdAddressDto {
    @JsonIgnore
    private int iuser;
    private int iaddress;
    private String zipCode;
    private String address;
    private String addressDetail;
}
