package com.fav.fav.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    // AsyncConfigurer : 비동기 처리를 위한 설정을 제공하는 인터페이스(spring 기본)
    // AsyncConfig : 비동기 설정을 위한 클래스

    /**
     * 기본적으로 비동기 처리를 위한 ThreadPool 설정
     * 
     * AsyncConfigurer 인터페이스를 구현하고 getAsyncExecutor() 메서드를 오버라이드하여 
     * 비동기 처리를 위한 ThreadPoolTaskExecutor를 반환한다.
     *
     * @return Executor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 기본 스레드 수
        executor.setMaxPoolSize(10); // 최대 스레드 수
        executor.setQueueCapacity(25); // 큐의 최대 크기
        executor.setThreadNamePrefix("async-executor-"); // 스레드 이름 접두사 설정
        executor.initialize();
        return executor;
    }

    /**
     * 비동기 처리 중 발생한 예외 처리
     * 
     * 비동기 처리 중 예외가 발생하면 예외를 처리하는 로직을 구현
     *
     * @return AsyncUncaughtExceptionHandler
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(
                    @SuppressWarnings("null") Throwable throwable,
                    @SuppressWarnings("null") Method method,
                    @SuppressWarnings("null") Object... obj) {
                // 예외를 처리하는 로직
                log.error("예외 발생: " + throwable.getMessage());
                log.error("메서드 이름: " + method.getName());
            }
        };
    }
}