package com.coen.coupon.persistence;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.entity.UserCouponEntity;
import com.coen.coupon.persistence.jpa.CouponJpaRepository;
import com.coen.coupon.persistence.jpa.UserCouponJpaRepository;
import com.coen.coupon.usecase.port.CouponIssueRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CouponIssueRepositoryImpl implements CouponIssueRepository {

    private final CouponJpaRepository couponJpaRepository;
    private final UserCouponJpaRepository userCouponJpaRepository;

    public CouponIssueRepositoryImpl(CouponJpaRepository couponJpaRepository, UserCouponJpaRepository userCouponJpaRepository) {
        this.couponJpaRepository = couponJpaRepository;
        this.userCouponJpaRepository = userCouponJpaRepository;
    }

    @Override
    public UserCoupon issueCoupon(Coupon coupon, Long userId) {
        UserCouponEntity userCouponEntity = UserCouponEntity.of(userId, CouponEntity.from(coupon));
        couponJpaRepository.save(CouponEntity.from(coupon));
        return userCouponJpaRepository.save(userCouponEntity)
                .toDomain();
    }
}
