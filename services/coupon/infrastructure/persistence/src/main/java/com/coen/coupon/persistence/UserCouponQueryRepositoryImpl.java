package com.coen.coupon.persistence;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.entity.UserCouponEntity;
import com.coen.coupon.persistence.jpa.UserCouponJpaRepository;
import com.coen.coupon.usecase.port.UserCouponQueryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCouponQueryRepositoryImpl implements UserCouponQueryRepository {

    private final UserCouponJpaRepository userCouponJpaRepository;

    public UserCouponQueryRepositoryImpl(UserCouponJpaRepository userCouponJpaRepository) {
        this.userCouponJpaRepository = userCouponJpaRepository;
    }

    @Override
    public List<UserCoupon> findAllByCoupon(Coupon coupon) {
        return userCouponJpaRepository.findAllByCoupon(CouponEntity.from(coupon))
                .stream()
                .map(UserCouponEntity::toDomain)
                .toList();
    }
}
