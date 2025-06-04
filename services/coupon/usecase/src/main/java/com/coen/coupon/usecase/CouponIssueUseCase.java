package com.coen.coupon.usecase;

import com.coen.coupon.domain.Coupon;
import com.coen.coupon.domain.UserCoupon;
import com.coen.coupon.usecase.port.CouponIssueRepository;
import com.coen.coupon.usecase.port.CouponQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponIssueUseCase {

    private final CouponQueryRepository couponQueryRepository;
    private final CouponIssueRepository couponIssueRepository;

    public CouponIssueUseCase(CouponQueryRepository couponQueryRepository, CouponIssueRepository couponIssueRepository) {
        this.couponQueryRepository = couponQueryRepository;
        this.couponIssueRepository = couponIssueRepository;
    }

    public UserCoupon issueCoupon(Long couponId, Long userId) {
        // 유저 id 확인
        // 쿠폰id 유효성 체크 필요
        Coupon coupon = couponQueryRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("없는 쿠폰번호 입니다. couponId: " + couponId));
        return couponIssueRepository.issueCoupon(coupon, userId);
    }
}
