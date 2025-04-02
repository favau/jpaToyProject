package com.fav.fav.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.fav.fav.common.ProcessResult;

public class ValidationException {

    // DTO,Model의 필드명과 오류메세지를 반환 중첩 클래스
    public static class ValidationError {
        private String fieldName; // key
        private String errorMessage; // value

        public ValidationError(String fieldName, String errorMessage) {
            this.fieldName = fieldName;
            this.errorMessage = errorMessage;
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    // 유효성 검사 오류를 확인하는 메서드
    public <R> ProcessResult<R> validationException(BindingResult bindingResult/*, String moduleName*/) {
        // String moduleFix = moduleName + "생성";
        ProcessResult<R> processResult = null;

        // 유효성 검사 오류 메시지를 저장할 객체 리스트 생성
        List<ValidationError> validationErrors = new ArrayList<>();
        // 오류 메시지를 리스트에 추가
        bindingResult.getFieldErrors().forEach(error -> {
            ValidationError validationError = new ValidationError(
                    error.getField(), // 필드명
                    error.getDefaultMessage() // 오류 메시지
            );
            validationErrors.add(validationError);
        });
        // ProcessResult에 validationList로 객체 리스트 추가
        processResult = ProcessResult.<R>builder()
                .isResult(false)
                .resultCode(-2)
                .validationList(validationErrors) // 객체 리스트로 추가
                // .resultMessage(String.format("%s > 유효성 검사 오류", moduleFix))    //messageBox 없이 front에서 처리?
                .build();
        return processResult;
    }
}