package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserSelToModifyVo {
    @JsonIgnore
    private String upw;
    private int result;
    private String nm;
    private String phoneNumber;
    private String email;
    private List<UserChildVo> children;
}
