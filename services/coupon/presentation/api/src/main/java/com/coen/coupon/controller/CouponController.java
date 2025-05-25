package com.coen.coupon.controller;

import com.coen.coupon.Coupon;
import com.coen.coupon.CouponCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/coupons")
public class CouponController {

    private final CouponCreateUseCase couponCreateUseCase;

    @GetMapping
    public String coupons(@RequestParam Long id, @RequestParam String name) {
        Coupon coupon = couponCreateUseCase.createCoupon(id, name);
        return coupon.toString();
    }
}

/**
 * api에서 compileOnly를 사용하여 api가 바로 infrastrucure를 의조하고 있는데, 어떻게 처리해야할까... 이것도 트레이드 오프인걸까?
 * 의존성 방향성을 사용해 프로젝트 모듈을 바꾼 회고를 블로그에 적어보자.
 */