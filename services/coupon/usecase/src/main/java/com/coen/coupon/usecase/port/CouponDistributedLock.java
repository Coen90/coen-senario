package com.coen.coupon.usecase.port;

public interface CouponDistributedLock {

    boolean getLock(Long couponId, Long userId) throws InterruptedException;

    void releaseLock(Long couponId);
}
