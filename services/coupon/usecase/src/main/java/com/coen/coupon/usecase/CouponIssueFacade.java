package com.coen.coupon.usecase;

import com.coen.coupon.domain.model.UserCoupon;
import com.coen.coupon.usecase.port.CouponDistributedLock;
import org.springframework.stereotype.Service;

@Service
public class CouponIssueFacade {

    private final CouponIssueUseCase couponIssueUseCase;

    private final CouponDistributedLock couponDistributedLock;

    public CouponIssueFacade(CouponIssueUseCase couponIssueUseCase, CouponDistributedLock couponDistributedLock) {
        this.couponIssueUseCase = couponIssueUseCase;
        this.couponDistributedLock = couponDistributedLock;
    }

    public UserCoupon issueCoupon(Long couponId, Long userId) {
        try {
            if (couponDistributedLock.getLock(couponId, userId)) {
                return couponIssueUseCase.issueCoupon(couponId, userId);
            } else {
                throw new RuntimeException("락 획득 실패: couponId = " + couponId + ", userId = " + userId);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Internal server error: " + e.getMessage());
        } finally {
            couponDistributedLock.releaseLock(couponId);
        }
    }
}
