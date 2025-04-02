package com.fav.fav.project1.mybatisExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fav.fav.project1.mybatisExample.data.MybatisExampleRequestDto;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleResponseDto;
import com.fav.fav.project1.mybatisExample.service.MybatisExampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

import com.fav.fav.common.ProcessResult;
import com.fav.fav.common.exception.CustomRuntimeException;

@Slf4j
@RestController
@RequestMapping("/project1/mybatisExample")
@RequiredArgsConstructor
public class MybatisExampleController {
    private final String moduleName = "mybatisExample";
    ProcessResult<MybatisExampleResponseDto> processResult = null;

    @Autowired // 의존성 주입(Dependency Injection)을 자동으로 수행하는 어노테이션
    private final MybatisExampleService testService;

    @GetMapping("read")
    public ProcessResult<MybatisExampleResponseDto> read(MybatisExampleRequestDto requestDto) {
        String moduleFix = moduleName + "생성";
        ProcessResult<MybatisExampleResponseDto> processResult = null;

        try {
            List<MybatisExampleResponseDto> responseDto = testService.read(requestDto);

            processResult = ProcessResult.<MybatisExampleResponseDto>builder()
                    .isResult(true)
                    .resultCode(0)
                    .resultMessage(String.format("%s > 성공", moduleFix))
                    .resultList(responseDto)
                    .build();

        } catch (Exception e) {
            log.error("{}", e.getMessage(), e); // 일반적인 예외 처리 로그 추가
            String message = CustomRuntimeException.getErrorMessage(e);
            processResult = ProcessResult.<MybatisExampleResponseDto>builder()
                    .isResult(false)
                    .resultCode(-1)
                    .resultMessage(String.format("%s > 실패 - 원인[%s]", moduleFix, message))
                    .build();
        }
        return processResult;
    }
}
