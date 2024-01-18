package com.baby.babycareproductsshop.user.model;

import com.baby.babycareproductsshop.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserSignInDto {
    @Schema(defaultValue = "bottle123")
    @NotBlank(message = Const.ID_BLANK_MSG)
    private String uid;
    @Schema(defaultValue = "xptmxm123!@#")
    @NotBlank(message = Const.PASSWORD_BLANK_MSG)
    private String upw;
}
