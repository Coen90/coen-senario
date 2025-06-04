package com.coen.coupon.domain.exception;

public abstract class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return errorCode.getCode() / 100;
    }
}
