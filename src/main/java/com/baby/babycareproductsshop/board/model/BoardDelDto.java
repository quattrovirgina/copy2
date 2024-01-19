package com.baby.babycareproductsshop.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// 생성 2024-01-18
@Data
public class BoardDelDto {
    @Schema(title = "게시글 PK", description = "")
    private int iboard;
    @Schema(title = "회원 PK", description = "")
    private int iuser;
}