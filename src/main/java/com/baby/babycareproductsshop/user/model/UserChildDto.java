package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserChildDto {
    @JsonIgnore
    private int iuser;
    private int ichildAge;
    private String gender;
}
