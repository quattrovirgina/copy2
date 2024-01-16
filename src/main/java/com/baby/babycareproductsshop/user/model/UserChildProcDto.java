package com.baby.babycareproductsshop.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserChildProcDto {
    private int iuser;
    private final List<UserChildDto> children;
}
