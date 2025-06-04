package com.coen.coupon.persistence;

import com.coen.coupon.domain.Coupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.jpa.CouponJpaRepository;
import com.coen.coupon.usecase.port.CouponQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponQueryRepositoryImpl implements CouponQueryRepository {

    private final CouponJpaRepository couponJpaRepository;

    @Override
    public Optional<Coupon> findById(Long couponId) {
        return couponJpaRepository.findById(couponId)
                .map(CouponEntity::toDomain);
    }
}
