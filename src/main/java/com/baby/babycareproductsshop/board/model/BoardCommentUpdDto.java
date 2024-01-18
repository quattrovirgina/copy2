package com.baby.babycareproductsshop.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BoardCommentUpdDto {
    @Schema(title = "댓글 PK", description = "")
    private int icomment;
    @Schema(title = "댓글 내용", description = "")
    private String comment;
}
