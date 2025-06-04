package com.coen.coupon.persistence;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.jpa.UserCouponJpaRepository;
import com.coen.coupon.usecase.port.UserCouponQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserCouponQueryRepositoryImpl implements UserCouponQueryRepository {

    private final UserCouponJpaRepository userCouponJpaRepository;

    public UserCouponQueryRepositoryImpl(UserCouponJpaRepository userCouponJpaRepository) {
        this.userCouponJpaRepository = userCouponJpaRepository;
    }

    @Override
    public long countAllByCoupon(Coupon coupon) {
        return userCouponJpaRepository.countAllByCoupon(CouponEntity.from(coupon));
    }
}
