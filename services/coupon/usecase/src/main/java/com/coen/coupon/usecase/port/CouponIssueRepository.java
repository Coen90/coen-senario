package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.Coupon;
import com.coen.coupon.domain.UserCoupon;

public interface CouponIssueRepository {
    UserCoupon issueCoupon(Coupon coupon, Long userId);
}
