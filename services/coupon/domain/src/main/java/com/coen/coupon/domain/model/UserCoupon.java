package com.coen.coupon.domain.model;

import java.time.LocalDateTime;

public record UserCoupon(
        Long id,
        Long userId,
        Coupon coupon,
        LocalDateTime issuedAt,
        LocalDateTime expiredAt
) {
}
