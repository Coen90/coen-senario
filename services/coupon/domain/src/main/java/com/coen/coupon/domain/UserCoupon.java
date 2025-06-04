package com.coen.coupon.domain;

import java.time.LocalDateTime;

public record UserCoupon(
        Long id,
        Long couponId,
        Long name,
        LocalDateTime issuedAt,
        LocalDateTime expiredAt
) {
}
