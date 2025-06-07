package com.coen.coupon.domain.model;

public record Coupon(
        Long id,
        String name,
        String description,
        Long maximumIssueCount,
        Long remainingIssueCount
) {
    public boolean canBeIssued() {
        return remainingIssueCount > 0;
    }

    public Coupon issue() {
        return new Coupon(
                id,
                name,
                description,
                maximumIssueCount,
                remainingIssueCount - 1
        );
    }
}
