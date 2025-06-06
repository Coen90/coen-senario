package com.coen.coupon.domain.exception;

public class CouponNotFoundException extends BusinessException {
    public CouponNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
