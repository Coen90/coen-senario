package com.coen.coupon.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CouponApplicationTest {
    @Test
    void concurrentCouponIssueTest() throws InterruptedException {
        int threadCount = 10000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int userId = i;

            executorService.submit(() -> {
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.postForEntity(
                            "http://localhost/api/v1/coupons/issue",
                            new HttpEntity<>(Map.of("userId", userId, "couponId", 1L)),
                            String.class
                    );
                } catch (Exception e) {
                    System.err.println("요청 실패: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
    }
}