package com.baby.babycareproductsshop.board.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardInsDto {
    private int iboard;
    private int iuser;
    private int boardCode;
    private String title;
    private String contents;
    private List<MultipartFile> pics;
}