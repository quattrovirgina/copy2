package com.baby.babycareproductsshop.board.model;

import lombok.Data;

@Data
public class BoardGetVo {
    private int iboard;
    private String title;
    private int boardCode;
    private String createdAt;
}
