package com.coen.coupon.persistence;

import com.coen.coupon.domain.Coupon;
import com.coen.coupon.domain.UserCoupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.entity.UserCouponEntity;
import com.coen.coupon.persistence.jpa.UserCouponJpaRepository;
import com.coen.coupon.usecase.port.CouponIssueRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CouponIssueRepositoryImpl implements CouponIssueRepository {

    private final UserCouponJpaRepository userCouponJpaRepository;

    public CouponIssueRepositoryImpl(UserCouponJpaRepository userCouponJpaRepository) {
        this.userCouponJpaRepository = userCouponJpaRepository;
    }

    @Override
    public UserCoupon issueCoupon(Coupon coupon, Long userId) {
        UserCouponEntity userCouponEntity = UserCouponEntity.of(userId, CouponEntity.from(coupon));
        return userCouponJpaRepository.save(userCouponEntity)
                .toDomain();
    }
}
