package com.coen.coupon.persistence.entity;

import com.coen.coupon.domain.model.UserCoupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_coupons")
public class UserCouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime issuedAt;

    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    private CouponEntity coupon;

    protected UserCouponEntity() {
    }

    @Builder(access = AccessLevel.PRIVATE)
    public UserCouponEntity(Long userId, CouponEntity coupon, LocalDateTime issuedAt, LocalDateTime expiredAt) {
        this.userId = userId;
        this.coupon = coupon;
        this.issuedAt = issuedAt;
        this.expiredAt = expiredAt;
    }

    public UserCoupon toDomain() {
        return new UserCoupon(id, userId, 1L, issuedAt, expiredAt);
    }

    public static UserCouponEntity of(long userId, CouponEntity coupon) {
        LocalDateTime currentAt = LocalDateTime.now();
        return UserCouponEntity.builder()
                .userId(userId)
                .coupon(coupon)
                .issuedAt(currentAt)
                .expiredAt(currentAt.plusDays(7))
                .build();
    }
}
