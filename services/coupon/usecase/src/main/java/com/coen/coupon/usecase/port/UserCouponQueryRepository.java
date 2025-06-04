package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.model.Coupon;

public interface UserCouponQueryRepository {

    long countAllByCoupon(Coupon coupon);
}
