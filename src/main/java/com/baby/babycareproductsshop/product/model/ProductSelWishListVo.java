package com.baby.babycareproductsshop.product.model;

import lombok.Data;

@Data
public class ProductSelWishListVo {
    private int iproduct;
    private String productNm;
    private String price;
    private int newFl;
    private int rcFl;
    private int popFl;
    private int reviewCnt;
    private int isWishList; //1 = 찜한 상품. 0 = 찜하지 않은 상품
}
