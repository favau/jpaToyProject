package com.fav.fav.common.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {
    
    // SQL error
    DATA_NOT_FOUND_CREATE(HttpStatus.INTERNAL_SERVER_ERROR, 600, "Q001", "데이터 생성에 실패했습니다."),
    DATA_NOT_FOUND_SELECT(HttpStatus.INTERNAL_SERVER_ERROR, 601, "Q002", "데이터 읽기에 실패했습니다."),
    DATA_NOT_FOUND_UPDATE(HttpStatus.INTERNAL_SERVER_ERROR, 602, "Q003", "데이터 수정에 실패했습니다."),
    DATA_NOT_FOUND_DELETE(HttpStatus.INTERNAL_SERVER_ERROR, 603, "Q004", "데이터 삭제에 실패했습니다."),
    SQL_SYNTAX_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 604, "Q005", "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요."),

    ;
    private final HttpStatus status;
    private final int error;
    private final String divCode;
    private final String message;

}
