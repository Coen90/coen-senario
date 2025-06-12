package com.coen.coupon.api.controller;

import com.coen.coupon.api.controller.request.CouponIssueRequest;
import com.coen.coupon.usecase.CouponIssueFacade;
import com.coen.coupon.usecase.CouponIssueUseCase;
import com.coen.coupon.domain.model.UserCoupon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupons/issue")
public class CouponController {

    private final CouponIssueUseCase couponIssueUseCase;

    private final CouponIssueFacade couponIssueFacade;

    public CouponController(CouponIssueUseCase couponIssueUseCase, CouponIssueFacade couponIssueFacade) {
        this.couponIssueUseCase = couponIssueUseCase;
        this.couponIssueFacade = couponIssueFacade;
    }

    @PostMapping
    public ResponseEntity<UserCoupon> issueCoupon(@RequestBody CouponIssueRequest request) {
        UserCoupon userCoupon = couponIssueFacade.issueCoupon(request.couponId(), request.userId());
        return ResponseEntity.ok(userCoupon);
    }
}
