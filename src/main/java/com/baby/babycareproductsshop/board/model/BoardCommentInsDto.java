package com.baby.babycareproductsshop.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BoardCommentInsDto {
    @Schema(title = "게시판 PK", description = "")
    private int iboard;
    @Schema(title = "회원 PK", description = "")
    private int iuser;
    @Schema(title = "댓글 내용", description = "")
    private String comment;
}
