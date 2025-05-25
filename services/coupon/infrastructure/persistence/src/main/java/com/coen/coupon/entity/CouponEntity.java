package com.coen.coupon.entity;

import com.coen.coupon.Coupon;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupons")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponEntity {
    @Id
    private Long id;

    private String name;

    public Coupon toDomain() {
        return new Coupon(id, name);
    }
}
