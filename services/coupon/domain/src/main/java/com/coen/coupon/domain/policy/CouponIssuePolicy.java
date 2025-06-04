package com.coen.coupon.domain.policy;

import com.coen.coupon.domain.exception.CouponIssueCountExceededException;
import org.springframework.stereotype.Component;

@Component
public class CouponIssuePolicy {

    public void validateCount(long issuedCount, long maximumIssueCount) {
        if (issuedCount >= maximumIssueCount) {
            throw new CouponIssueCountExceededException("쿠폰 발급 수량이 초과되었습니다. 현재 발급된 수량: " + issuedCount + ", 최대 발급 가능 수량: " + maximumIssueCount);
        }
    }
}
