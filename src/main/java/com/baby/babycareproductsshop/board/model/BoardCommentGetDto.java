package com.baby.babycareproductsshop.board.model;

import lombok.Data;

@Data
public class BoardCommentGetDto {
    private int icomment;
    private int iuser;
    private int nm;
    private int comment;
    private String createdAt;
}
