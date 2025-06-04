package com.coen.coupon.domain;

public record Coupon(
        Long id,
        String name,
        String description,
        Long maximumIssueCount
) {
}
