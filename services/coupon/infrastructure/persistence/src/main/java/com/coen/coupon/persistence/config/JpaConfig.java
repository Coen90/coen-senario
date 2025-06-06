package com.coen.coupon.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.coen.coupon.persistence.**")
public class JpaConfig {
}
