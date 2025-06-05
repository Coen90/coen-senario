package com.coen.coupon.api.advice;

import com.coen.coupon.api.advice.response.ErrorResponse;
import com.coen.coupon.domain.exception.BusinessException;
import com.coen.coupon.domain.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CouponControllerAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        log.error("Business exception occurred: {}", e.getMessage(), e);
        return ResponseEntity.status(e.getStatusCode())
                .body(ErrorResponse.from(errorCode));
    }
}
