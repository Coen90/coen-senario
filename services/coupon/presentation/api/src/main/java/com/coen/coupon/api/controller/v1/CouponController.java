package com.coen.coupon.api.controller.v1;

import com.coen.coupon.usecase.CouponIssueUseCase;
import com.coen.coupon.domain.model.UserCoupon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/coupons")
public class CouponController {

    private final CouponIssueUseCase couponIssueUseCase;

    public CouponController(CouponIssueUseCase couponIssueUseCase) {
        this.couponIssueUseCase = couponIssueUseCase;
    }

    @GetMapping
    public ResponseEntity<UserCoupon> issueCoupon(@RequestParam Long couponId, @RequestParam Long userId) {
        UserCoupon userCoupon = couponIssueUseCase.issueCoupon(couponId, userId);
        return ResponseEntity.ok(userCoupon);
    }
}

/**
 * api에서 compileOnly를 사용하여 api가 바로 infrastrucure를 의조하고 있는데, 어떻게 처리해야할까... 이것도 트레이드 오프인걸까?
 * 의존성 방향성을 사용해 프로젝트 모듈을 바꾼 회고를 블로그에 적어보자.
 */