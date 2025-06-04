package com.coen.coupon.persistence.jpa;

import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.entity.UserCouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCouponJpaRepository extends JpaRepository<UserCouponEntity, Long> {

    long countAllByCoupon(CouponEntity couponEntity);
}
