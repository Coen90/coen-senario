package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.model.Coupon;

import java.util.Optional;

public interface CouponQueryRepository {

    Optional<Coupon> findById(Long couponId);
}
