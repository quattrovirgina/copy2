package com.baby.babycareproductsshop.user.model;

import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.validation.ValidationGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "회원가입 시 필요한 고객 요청 데이터")
public class UserSignUpDto {
    @JsonIgnore
    private int iuser;

    @Schema(description = "유저 아이디", example = "Test1234")
    @NotNull(message = Const.ID_BLANK_MSG, groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$",
            message = "아이디는 공백을 제외한 영어나 숫자로 이루어진 4~10자리이어야 합니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String uid;

    @Schema(description = "유저 비밀번호", example = "특수문자는 @$!%*?&#~_-를 사용할 수 있습니다.")
    @NotNull(message = Const.PASSWORD_BLANK_MSG, groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#~_-])[A-Za-z\\d@$!%*?&#.~_-]{8,16}$",
            message = "비밀번호는 공백을 제외한 영어와 숫자, 특수문자를 하나 이상 포함한 8~16자리이어야 합니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String upw;

    @NotBlank(message = "닉네임을 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
    private String nm;

    @NotBlank(message = Const.NOT_ALLOWED_ZIP_CODE, groups = ValidationGroup.NotBlankGroup.class)
    private String zipCode;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS, groups = ValidationGroup.NotBlankGroup.class)
    private String address;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS_DETAIL, groups = ValidationGroup.NotBlankGroup.class)
    private String addressDetail;

    @NotNull(message = "전화번호를 입력해주세요.", groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}",
            message = "올바르지 않은 전화번호 형식입니다.")
    private String phoneNumber;

    @NotNull(message = "이메일을 입력해주세요.", groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "\\w+@\\w{3,}\\.([a-zA-Z]{2,}|[a-zA-Z]{2,}\\.[a-zA-Z]{2,})",
            message = "올바르지 않은 이메일 형식입니다.")
    private String email;

    @Size(min = 1, max = 3, message = "아이 정보는 최소 1명 최대 3명까지 입력할 수 있습니다.")
    private List<@Valid UserChildDto> children;
}