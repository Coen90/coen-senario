package com.coen.coupon.domain.exception;

public class CouponIssueCountExceededException extends BusinessException {
    public CouponIssueCountExceededException(String message) {
        super(ErrorCode.COUPON_ISSUE_COUNT_EXCEEDED, message);
    }
}
