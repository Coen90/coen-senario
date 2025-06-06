package com.coen.coupon.usecase.port;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;

import java.util.List;

public interface UserCouponQueryRepository {

    List<UserCoupon> findAllByCoupon(Coupon coupon);
}
