package com.coen.coupon.domain.policy;

import com.coen.coupon.domain.exception.CouponAlreadyIssuedException;
import com.coen.coupon.domain.exception.CouponIssueCountExceededException;
import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.domain.model.UserCoupon;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CouponIssuePolicy {

    public void validateCount(Coupon coupon, List<UserCoupon> userCoupons, Long userId) {
        if (!coupon.canBeIssued()) {
            throw new CouponIssueCountExceededException("쿠폰 발급 수량이 초과되었습니다. 현재 발급 가능한 수량: " + coupon.remainingIssueCount() + ", 최대 발급 가능 수량: " + coupon.maximumIssueCount());
        }
        if (isUserIssued(userCoupons, userId)) {
            throw new CouponAlreadyIssuedException("이미 발급된 쿠폰입니다. userId: " + userId);
        }
    }

    private boolean isUserIssued(List<UserCoupon> userCoupons, Long userId) {
        return userCoupons.stream()
                .map(UserCoupon::userId)
                .anyMatch(id -> Objects.equals(id, userId));
    }
}
