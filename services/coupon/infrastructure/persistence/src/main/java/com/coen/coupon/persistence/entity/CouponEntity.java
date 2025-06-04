package com.coen.coupon.persistence.entity;

import com.coen.coupon.domain.Coupon;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "coupons")
public class CouponEntity {
    @Id
    private Long id;

    private String name;

    private String description;

    private Long maximumIssueCount;

//    private List<UserCouponEntity> userCoupons;

    protected CouponEntity() {
    }

    @Builder(access = AccessLevel.PRIVATE)
    private CouponEntity(Long id, String name, String description, Long maximumIssueCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maximumIssueCount = maximumIssueCount;
    }

    public static CouponEntity from(Coupon coupon) {
        return CouponEntity.builder()
                .id(coupon.id())
                .name(coupon.name())
                .description(coupon.description())
                .maximumIssueCount(coupon.maximumIssueCount())
                .build();
    }

    public Coupon toDomain() {
        return new Coupon(id, name, description, maximumIssueCount);
    }
}
