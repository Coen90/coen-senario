package com.coen.coupon;

import com.coen.coupon.entity.CouponEntity;
import com.coen.coupon.port.CouponCreateRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CouponCreateRepositoryImpl implements CouponCreateRepository {

    @Override
    public Coupon createCoupon(Long id, String name) {
        CouponEntity couponEntity = new CouponEntity(id, name);
        return couponEntity.toDomain();
    }
}
