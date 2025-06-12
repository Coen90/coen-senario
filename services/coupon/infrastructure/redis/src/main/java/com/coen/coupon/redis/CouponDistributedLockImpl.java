package com.coen.coupon.redis;

import com.coen.coupon.usecase.port.CouponDistributedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class CouponDistributedLockImpl implements CouponDistributedLock {

    private final RedissonClient redissonClient;

    public CouponDistributedLockImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public boolean getLock(Long couponId, Long userId) throws InterruptedException {
        RLock lock = redissonClient.getLock(couponId.toString());
        return lock.tryLock(10, 1, TimeUnit.SECONDS);
    }

    @Override
    public void releaseLock(Long couponId) {
        redissonClient.getLock(couponId.toString())
                .unlock();
    }
}
