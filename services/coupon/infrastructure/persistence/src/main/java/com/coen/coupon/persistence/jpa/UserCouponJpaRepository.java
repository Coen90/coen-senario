package com.coen.coupon.persistence.jpa;

import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.entity.UserCouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCouponJpaRepository extends JpaRepository<UserCouponEntity, Long> {

    List<UserCouponEntity> findAllByCoupon(CouponEntity coupon);
}
