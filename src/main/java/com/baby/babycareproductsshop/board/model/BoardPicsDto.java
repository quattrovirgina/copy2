package com.baby.babycareproductsshop.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardPicsDto {
    private int iboard;
    private int boardCode;
    private List<MultipartFile> pics = new ArrayList<>();
    private List<String> picNames = new ArrayList<>();
}