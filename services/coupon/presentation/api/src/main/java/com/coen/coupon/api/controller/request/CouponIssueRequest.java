package com.coen.coupon.api.controller.request;

public record CouponIssueRequest(
        Long couponId,
        Long userId
) {
}
