package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;

public interface CouponIssueRepository {

    UserCoupon issueCoupon(Coupon coupon, Long userId);
}
