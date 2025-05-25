package com.coen.coupon.port;

import com.coen.coupon.Coupon;

public interface CouponCreateRepository {
    Coupon createCoupon(Long id, String name);
}
