package com.coen.coupon.persistence.entity;

import com.coen.coupon.domain.model.Coupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "coupons")
public class CouponEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long maximumIssueCount;

    @Column(nullable = false)
    private Long remainingIssueCount;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<UserCouponEntity> userCoupons = new ArrayList<>();

    protected CouponEntity() {
    }

    @Builder(access = AccessLevel.PRIVATE)
    private CouponEntity(Long id, String name, String description, Long maximumIssueCount, Long remainingIssueCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maximumIssueCount = maximumIssueCount;
        this.remainingIssueCount = remainingIssueCount;
    }

    public static CouponEntity from(Coupon coupon) {
        return CouponEntity.builder()
                .id(coupon.id())
                .name(coupon.name())
                .description(coupon.description())
                .maximumIssueCount(coupon.maximumIssueCount())
                .remainingIssueCount(coupon.remainingIssueCount())
                .build();
    }

    public Coupon toDomain() {
        return new Coupon(id, name, description, maximumIssueCount, remainingIssueCount);
    }
}
