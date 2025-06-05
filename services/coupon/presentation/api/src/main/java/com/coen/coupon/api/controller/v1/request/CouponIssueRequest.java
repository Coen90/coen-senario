package com.coen.coupon.api.controller.v1.request;

public record CouponIssueRequest(
        Long couponId,
        Long userId
) {
}
