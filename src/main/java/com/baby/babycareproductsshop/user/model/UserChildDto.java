package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserChildDto {
    @JsonIgnore
    private int iuser;
    @Min(value = 1, message = "아이의 나이대를 다시 선택해주세요.")
    @Max(value = 4, message = "아이의 나이대를 다시 선택해주세요.")
    private int ichildAge;
    @Pattern(regexp = "[WM]", message = "아이 성별은 W / M 으로 입력해주세요.")
    private String gender;
}
