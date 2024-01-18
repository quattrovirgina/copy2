package com.baby.babycareproductsshop.user.model;

import com.baby.babycareproductsshop.common.Const;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCheckUpwDto {
    @NotBlank(message = Const.PASSWORD_BLANK_MSG)
    private String upw;
}
