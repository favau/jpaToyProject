package com.fav.fav.project1.structureTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fav.fav.project1.structureTest.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/project1/test")
@RequiredArgsConstructor
public class TestController {
    private final String moduleName = "test";

    @Autowired //의존성 주입(Dependency Injection)을 자동으로 수행하는 어노테이션
    private final TestService testService;
    
}
