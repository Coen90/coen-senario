package com.coen.coupon.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    COUPON_ISSUE_COUNT_EXCEEDED(40901, "쿠폰 발급 수량 초과"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
