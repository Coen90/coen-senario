package com.coen.coupon.api.controller;

import com.coen.coupon.api.controller.request.CouponIssueRequest;
import com.coen.coupon.usecase.CouponIssueUseCase;
import com.coen.coupon.domain.model.UserCoupon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupons/issue")
public class CouponController {

    private final CouponIssueUseCase couponIssueUseCase;

    public CouponController(CouponIssueUseCase couponIssueUseCase) {
        this.couponIssueUseCase = couponIssueUseCase;
    }

    @PostMapping
    public ResponseEntity<UserCoupon> issueCoupon(@RequestBody CouponIssueRequest request) {
        UserCoupon userCoupon = couponIssueUseCase.issueCoupon(request.couponId(), request.userId());
        return ResponseEntity.ok(userCoupon);
    }
}
