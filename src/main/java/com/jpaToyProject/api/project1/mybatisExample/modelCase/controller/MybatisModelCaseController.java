package com.jpaToyProject.api.project1.mybatisExample.modelCase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaToyProject.api.common.ProcessResult;
import com.jpaToyProject.api.common.exception.CustomRuntimeException;
import com.jpaToyProject.api.project1.mybatisExample.modelCase.data.MybatisModelCaseRequestDto;
import com.jpaToyProject.api.project1.mybatisExample.modelCase.data.MybatisModelCaseResponseDto;
import com.jpaToyProject.api.project1.mybatisExample.modelCase.service.MybatisModelCaseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequestMapping("/project1/mybatisExample/mybatisModelCase")
@RequiredArgsConstructor
public class MybatisModelCaseController {
    private final String moduleName = "project1/mybatisExample/mybatisModelCase";
    ProcessResult<MybatisModelCaseResponseDto> processResult = null;

    @Autowired // 의존성 주입(Dependency Injection)을 자동으로 수행하는 어노테이션
    private final MybatisModelCaseService defaultService;

    @GetMapping("/read")
    public ProcessResult<MybatisModelCaseResponseDto> read(MybatisModelCaseRequestDto requestDto) {
        String moduleFix = moduleName + "생성";
        ProcessResult<MybatisModelCaseResponseDto> processResult = null;

        try {
            List<MybatisModelCaseResponseDto> responseDto = defaultService.read(requestDto);

            processResult = ProcessResult.<MybatisModelCaseResponseDto>builder()
                    .isResult(true)
                    .resultCode(0)
                    .resultMessage(String.format("%s > 성공", moduleFix))
                    .resultList(responseDto)
                    .build();

        } catch (Exception e) {
            log.error("{}", e.getMessage(), e); // 일반적인 예외 처리 로그 추가
            String message = CustomRuntimeException.getErrorMessage(e);
            processResult = ProcessResult.<MybatisModelCaseResponseDto>builder()
                    .isResult(false)
                    .resultCode(-1)
                    .resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, message))
                    .build();
        }
        return processResult;
    }
}
