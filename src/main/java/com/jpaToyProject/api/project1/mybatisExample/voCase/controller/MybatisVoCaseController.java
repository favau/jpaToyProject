package com.jpaToyProject.api.project1.mybatisExample.voCase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaToyProject.api.common.ProcessResult;
import com.jpaToyProject.api.common.exception.CustomRuntimeException;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseRequestDto;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseResponseDto;
import com.jpaToyProject.api.project1.mybatisExample.voCase.service.MybatisVoCaseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequestMapping("/project1/mybatisExample/mybatisVoCase")
@RequiredArgsConstructor
public class MybatisVoCaseController {
    private final String moduleName = "project1/mybatisExample/mybatisVoCase";
    ProcessResult<MybatisVoCaseResponseDto> processResult = null;

    @Autowired // 의존성 주입(Dependency Injection)을 자동으로 수행하는 어노테이션
    private final MybatisVoCaseService testService;

    @GetMapping("/read")
    public ProcessResult<MybatisVoCaseResponseDto> read(MybatisVoCaseRequestDto requestDto) {
        String moduleFix = moduleName + "생성";
        ProcessResult<MybatisVoCaseResponseDto> processResult = null;

        try {
            List<MybatisVoCaseResponseDto> responseDto = testService.read(requestDto);

            processResult = ProcessResult.<MybatisVoCaseResponseDto>builder()
                    .isResult(true)
                    .resultCode(0)
                    .resultMessage(String.format("%s > 성공", moduleFix))
                    .resultList(responseDto)
                    .build();

        } catch (Exception e) {
            log.error("{}", e.getMessage(), e); // 일반적인 예외 처리 로그 추가
            String message = CustomRuntimeException.getErrorMessage(e);
            processResult = ProcessResult.<MybatisVoCaseResponseDto>builder()
                    .isResult(false)
                    .resultCode(-1)
                    .resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, message))
                    .build();
        }
        return processResult;
    }
}
