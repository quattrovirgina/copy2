package com.baby.babycareproductsshop.exception;

import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.common.ResVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResVo NPE() {
        return new ResVo(Const.FAIL);
    }

    @ExceptionHandler(Exception.class)
    public ResVo E() {
        return new ResVo(Const.FAIL);
    }
}