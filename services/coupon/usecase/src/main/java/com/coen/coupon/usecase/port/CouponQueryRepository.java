package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.Coupon;

import java.util.Optional;

public interface CouponQueryRepository {

    Optional<Coupon> findById(Long couponId);
}
