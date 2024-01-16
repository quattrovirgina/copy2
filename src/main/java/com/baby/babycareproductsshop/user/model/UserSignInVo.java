package com.baby.babycareproductsshop.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSignInVo {
    private String nm;
    private int result;
    private String accessToken;
}
