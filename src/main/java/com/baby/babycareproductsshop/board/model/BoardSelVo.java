package com.baby.babycareproductsshop.board.model;

import lombok.Data;

@Data
public class BoardSelVo {
    private int iboard;
    private int iuser;
    private String title;
    private String nm;
    private String contents;
    private String createdAt;
}
