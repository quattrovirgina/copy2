package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserUpdDto {
    @JsonIgnore
    private int iuser;
    private String upw;
    private String nm;
    private String phoneNumber;
    private String email;
    private List<UserChildDto> children;
}
