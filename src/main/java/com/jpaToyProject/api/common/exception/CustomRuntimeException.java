package com.jpaToyProject.api.common.exception;

import lombok.Getter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor // 모든 필드를 받는 생성자
public class CustomRuntimeException extends RuntimeException {

    private final int errorCode; // 추가적인 필드
    private final String message; // 오류 메시지
    private final HttpStatus status; // HTTP 상태

    /**
     * 사용자에게 보여줄 에러메세지
     * ???언어별 메세지 출력 방식에 관한 고찰 필요
     * 
     * @param e 에러 객체
     * @return 에러메세지
     */
    public static String getErrorMessage(Exception e) {
        String message = null;
        if (e.getClass() == BadSqlGrammarException.class) {
            // 데이터베이스 관련 에러 발생 시
            message = "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요.(code : E0001)";
        } else if (e.getClass() == DataIntegrityViolationException.class) {
            // 제약 조건 무결성 관련 에러 발생 시
            message = "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요.(code : E0002)";
        } else if (e.getClass() == DuplicateKeyException.class) {
            // 제약 조건 무결성 관련 에러 - 고유키 제약조건 위반 발생 시
            message = "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요.(code : E0003)";
        } else if (e.getClass() == CannotGetJdbcConnectionException.class) {
            // 데이터베이스와의 연결 과정 문제 발생 시
            message = "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요.(code : E0004)";
        } else {
            message = e.getMessage();
        }
        return message;
    }

}
