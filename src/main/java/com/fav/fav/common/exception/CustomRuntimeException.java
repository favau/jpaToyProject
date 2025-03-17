package com.fav.fav.common.exception;

public class CustomRuntimeException extends RuntimeException {

    private int errorCode; // 추가적인 필드를 가질 수 있음

    // 기본 생성자
    public CustomRuntimeException() {
        super("커스텀 런타임 예외 발생");
    }

    // 메시지 전달하는 생성자
    public CustomRuntimeException(String message) {
        super(message);
    }

    // 메시지와 에러코드 전달하는 생성자
    public CustomRuntimeException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // 에러코드 getter
    public int getErrorCode() {
        return errorCode;
    }
}
