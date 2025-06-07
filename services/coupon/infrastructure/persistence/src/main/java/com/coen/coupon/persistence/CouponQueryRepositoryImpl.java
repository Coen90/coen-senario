package com.coen.coupon.persistence;

import com.coen.coupon.domain.model.Coupon;
import com.coen.coupon.persistence.entity.CouponEntity;
import com.coen.coupon.persistence.jpa.CouponJpaRepository;
import com.coen.coupon.usecase.port.CouponQueryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CouponQueryRepositoryImpl implements CouponQueryRepository {

    private final CouponJpaRepository couponJpaRepository;

    public CouponQueryRepositoryImpl(CouponJpaRepository couponJpaRepository) {
        this.couponJpaRepository = couponJpaRepository;
    }

    @Override
    public Optional<Coupon> findByIdWithPessimisticLock(Long couponId) {
        return couponJpaRepository.findWithPessimisticLock(couponId)
                .map(CouponEntity::toDomain);
    }
}
