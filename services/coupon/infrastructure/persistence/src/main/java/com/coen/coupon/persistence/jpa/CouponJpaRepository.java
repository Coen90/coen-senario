package com.coen.coupon.persistence.jpa;

import com.coen.coupon.persistence.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<CouponEntity, Long> {
}
