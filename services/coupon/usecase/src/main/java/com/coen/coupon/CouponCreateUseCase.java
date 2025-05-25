package com.coen.coupon;

import com.coen.coupon.port.CouponCreateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponCreateUseCase {
    private final CouponCreateRepository couponCreateRepository;

    public Coupon createCoupon(Long id, String name) {
        return couponCreateRepository.createCoupon(id, name);
    }
}
