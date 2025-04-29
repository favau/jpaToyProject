package com.jpaToyProject.api.common.history;
// package com.fav.fav.common.history;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.Aspect;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// public class HistoryAspect {

//     private final HistoryService historyService; // 히스토리 서비스 클래스 (DB에 기록하기 위해)

//     public HistoryAspect(HistoryService historyService) {
//         this.historyService = historyService;
//     }

//     // @AfterReturning은 메소드가 정상적으로 종료된 후 실행됩니다.
//     @AfterReturning(pointcut = "execution(* com.example.controller.*.*(..))", returning = "returnValue")
//     public void recordHistory(JoinPoint joinPoint, Object returnValue) {
//         long startTime = System.currentTimeMillis(); // 메소드 시작 시간

//         // 메소드 실행 후 결과를 처리합니다.
//         long endTime = System.currentTimeMillis(); // 메소드 종료 시간
//         long executionTime = endTime - startTime; // 실행 시간

//         // 필요한 데이터 준비 (예: 요청 URL, 요청 데이터 등)
//         String callUrl = "http://example.com/api"; // 예시로 하드코딩, 실제로는 joinPoint나 매개변수에서 받아올 수 있음
//         String requestData = "Sample Request Data"; // 실제 요청 데이터
//         String responseData = returnValue != null ? returnValue.toString() : "No Response";

//         // 결과 메시지 설정
//         String resultMessage = returnValue != null ? "Success" : "Failure";

//         // HistoryModel 생성
//         HistoryModel historyModel = HistoryModel.builder()
//                 .callUrl(callUrl)
//                 .requestData(requestData)
//                 .responseData(responseData)
//                 .processTime((int) executionTime)
//                 .resultMessage(resultMessage)
//                 .result(true) // 기본적으로 성공으로 설정
//                 .errorCode(0) // 기본적으로 0으로 설정 (에러 코드)
//                 .build();

//         // 히스토리 기록
//         historyService.saveHistory(historyModel); // DB에 기록하는 서비스 호출
//     }
// }
