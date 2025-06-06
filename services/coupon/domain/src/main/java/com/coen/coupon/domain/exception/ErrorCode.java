package com.coen.coupon.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    COUPON_NOT_FOUND(40401, "쿠폰을 찾을 수 없습니다"),
    COUPON_ISSUE_COUNT_EXCEEDED(40901, "쿠폰 발급 수량 초과"),
    COUPON_ALREADY_ISSUED(40902, "이미 발급된 쿠폰입니다"),
    INTERNAL_SERVER_ERROR(50001, "서버 에러"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
