package com.coen.coupon.api.advice.response;

import com.coen.coupon.domain.exception.ErrorCode;

public record ErrorResponse(int code, String message) {

    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage());
    }
}
