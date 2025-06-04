package com.coen.coupon.domain.model;

public record Coupon(
        Long id,
        String name,
        String description,
        Long maximumIssueCount
) {
}
