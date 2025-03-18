package com.fav.fav.common.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor // 모든 필드를 받는 생성자
public class CustomRuntimeException extends RuntimeException {

    private final int errorCode; // 추가적인 필드
    private final String message; // 오류 메시지
    private final HttpStatus status; // HTTP 상태

    // BizErrorCode를 통해 오류 코드와 메시지를 처리
    public CustomRuntimeException(BizErrorCode bizErrorCode) {
        super(bizErrorCode.getMessage());
        this.errorCode = bizErrorCode.getError();
        this.message = bizErrorCode.getMessage();
        this.status = bizErrorCode.getStatus();
    }
}
