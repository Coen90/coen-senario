package com.coen.coupon.domain.policy;

import com.coen.coupon.domain.exception.CouponAlreadyIssuedException;
import com.coen.coupon.domain.exception.CouponIssueCountExceededException;
import com.coen.coupon.domain.model.UserCoupon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CouponIssuePolicy {

    public void validateCount(List<UserCoupon> userCoupons, long userId, long maximumIssueCount) {
        if (userCoupons.size() >= maximumIssueCount) {
            throw new CouponIssueCountExceededException("쿠폰 발급 수량이 초과되었습니다. 현재 발급된 수량: " + userCoupons.size() + ", 최대 발급 가능 수량: " + maximumIssueCount);
        }
        boolean isIssued = userCoupons.stream()
                .map(UserCoupon::userId)
                .anyMatch(id -> id == userId);
        if (isIssued) {
            throw new CouponAlreadyIssuedException("이미 발급된 쿠폰입니다. userId: " + userId);
        }
    }
}
