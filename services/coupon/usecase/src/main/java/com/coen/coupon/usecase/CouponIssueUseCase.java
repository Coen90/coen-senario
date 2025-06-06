package com.coen.coupon.usecase;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;
import com.coen.coupon.domain.policy.CouponIssuePolicy;
import com.coen.coupon.usecase.port.CouponIssueRepository;
import com.coen.coupon.usecase.port.CouponQueryRepository;
import com.coen.coupon.usecase.port.UserCouponQueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CouponIssueUseCase {

    private final CouponQueryRepository couponQueryRepository;
    private final CouponIssueRepository couponIssueRepository;
    private final UserCouponQueryRepository userCouponQueryRepository;
    private final CouponIssuePolicy couponIssuePolicy;

    public CouponIssueUseCase(CouponQueryRepository couponQueryRepository, CouponIssueRepository couponIssueRepository, UserCouponQueryRepository userCouponQueryRepository, CouponIssuePolicy couponIssuePolicy) {
        this.couponQueryRepository = couponQueryRepository;
        this.couponIssueRepository = couponIssueRepository;
        this.userCouponQueryRepository = userCouponQueryRepository;
        this.couponIssuePolicy = couponIssuePolicy;
    }

    @Transactional
    public UserCoupon issueCoupon(Long couponId, Long userId) {
        // 유저 id 확인(유저 id는 항상 존재한다고 가정)
        Coupon coupon = couponQueryRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("없는 쿠폰번호 입니다. couponId: " + couponId));
        List<UserCoupon> userCoupons = userCouponQueryRepository.findAllByCoupon(coupon);
        couponIssuePolicy.validateCount(coupon, userCoupons, userId);
        return couponIssueRepository.issueCoupon(coupon, userId);
    }
}
