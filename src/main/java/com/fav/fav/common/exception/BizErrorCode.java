package com.fav.fav.common.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BizErrorCode {
    // Common
    NO_REQUEST_VALUE(HttpStatus.BAD_REQUEST, 400, "C001", "요청 정보가 없음"),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, 400, "C001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, 405, "C002", "Invalid Input Value"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, 403, "C006", "Access is Denied"),
    PROCESS_ABNORMAL_EXECUTION(HttpStatus.INTERNAL_SERVER_ERROR, 500, "C007", "비정상적인 프로세스 실행 입니다."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "C008", "데이터가 존재하지 않아 수정에 실패했습니다."),
    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "C009", "파일이 존재하지 않습니다."),
    ACCESS_DENIED(HttpStatus.NOT_FOUND, 404, "C010", "접근 권한이 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.NOT_FOUND, 404, "C011", "비밀번호가 일치하지 않습니다."),

    // SQL error
    DATA_NOT_FOUND_CREATE(HttpStatus.INTERNAL_SERVER_ERROR, 600, "Q001", "데이터 생성에 실패했습니다."),
    DATA_NOT_FOUND_SELECT(HttpStatus.INTERNAL_SERVER_ERROR, 601, "Q002", "데이터 읽기에 실패했습니다."),
    DATA_NOT_FOUND_UPDATE(HttpStatus.INTERNAL_SERVER_ERROR, 602, "Q003", "데이터 수정에 실패했습니다."),
    DATA_NOT_FOUND_DELETE(HttpStatus.INTERNAL_SERVER_ERROR, 603, "Q004", "데이터 삭제에 실패했습니다."),
    SQL_SYNTAX_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 604, "Q005", "시스템에 문제가 발생했습니다. 다시 시도하거나, 문제가 지속되면 관리자에게 문의해 주세요."),

    // Excel
    EXCEL_SHEET_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "E001", "일치하는 엑셀 파일 시트가 존재하지 않습니다."),
    EXCEL_CELL_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "E001", "일치하는 엑셀 파일 정보가 존재하지 않습니다."),

    // Mail
    MAIL_SEND_FAILED(HttpStatus.NOT_FOUND, 404, "M001", "메일 전송에 실패했습니다."),
    MAIL_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "M002", "메일 전송에 사용할 데이터가 존재하지 않습니다.");

    private final HttpStatus status;
    private final int error;
    private final String divCode;
    private final String message;

    // BizErrorCode를 통해 CustomRuntimeException 생성
    public CustomRuntimeException toCustomRuntimeException() {
        return new CustomRuntimeException(this);
    }
}
