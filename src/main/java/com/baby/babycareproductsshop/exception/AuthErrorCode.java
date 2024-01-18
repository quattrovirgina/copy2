package com.baby.babycareproductsshop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode{ //enum : Const 대체 할 수 있음.

    // 리뷰 에러코드
    UPLOAD_PIC_NOT_REVIEW(HttpStatus.NOT_FOUND, "사진은 최대 5장까지만 넣을 수 있습니다."),
    REVIEW_NOT_PRODUCT_SCORE_OR_CONTENTS(HttpStatus.NOT_FOUND,"사용하신 제품의 별점과 후기을 알려주세요!!"),
    UPLOAD_REVIEW_REGISTRATION_REVIEW(HttpStatus.OK,"리뷰가 정상적으로 등록되었습니다."),


//    NOT_ALLOWED_ADDRESS_DETAIL(HttpStatus.BAD_REQUEST, "상세 주소를 입력해주세요."),
//    NOT_ALLOWED_ADDRESS(HttpStatus.BAD_REQUEST, "주소를 입력해주세요."),
    INVALID_ADDRESS_SIZE(HttpStatus.BAD_REQUEST, "주소는 최소 1개 최대 3개 까지 입력할 수 있습니다."),
    DUPLICATED_UID(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디입니다."),
    PASSWORD_NOT_MATCHED(HttpStatus.NOT_FOUND, "비밀번호를 확인해주세요."),
    LOGIN_FAIL(HttpStatus.NOT_FOUND, "아이디와 비밀번호를 확인해주세요."),
    NEED_SIGNIN(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."),    //추가하고 싶으면 , 사용
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.NOT_FOUND, "refresh-token 이 없습니다.");

    //NOT_FOUND_REFRESH_TOKEN 가 멤버필드. -> 타입은 AuthErrorCode. 생성자를 통해서 값 주입


    private final HttpStatus httpStatus;
    private final String message;
    //enum은 name() 메서드를 자체적으로 구현 하고 있음. -> 오버라이딩 할 필요는 x
}
