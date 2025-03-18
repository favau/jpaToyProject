package com.fav.fav.common.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import com.fav.fav.common.exception.BizErrorCode;
import com.fav.fav.common.exception.CustomRuntimeException;

import jakarta.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    /*
     * spring-boot-starter-mail 의존성 추가
     * 추가 시 JavaMailSender와 관련된 설정 및 의존성이 자동으로 설정 (SMTP 설정 필요)
     *
     * org.springframework.mail 유틸 클래스
     * 텍스트 전송 / HTML 전송 / 첨부파일 전송
     * SimpleMailMessage 사용 O X X
     * MimeMessageHelper 사용(false) O X O
     * MimeMessageHelper 사용(true) O O O
     * 
     */

    /**
     * 입력받은 Object 타입의 데이터를 String[]로 변환하는 메서드
     * 
     * 입력받은 데이터가 String 또는 String[] 타입이 아닐 경우 예외 처리
     * 
     * @param obj (Object) 변환할 데이터
     * 
     * @throws Exception 데이터 타입 변환 중 발생할 수 있는 예외를 처리.
     *                   1.데이터가 null이거나 길이가 0인 경우 예외 처리
     *                   2.데이터가 String 또는 String[] 타입이 아닌 경우 예외 처리
     * 
     * @return String[] 변환된 데이터
     */
    private String[] convertObjectToArray(Object obj) throws Exception {
        if (obj instanceof String) { // obj가 String 타입인 경우
            if (obj == null || obj.toString().isEmpty()) // obj가 null이거나 길이가 0인 경우
                throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);
            return new String[] { (String) obj };
        } else if (obj instanceof String[]) { // obj가 String[] 타입인 경우
            if (obj == null || ((String[]) obj).length == 0) // obj가 null이거나 길이가 0인 경우
                throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);
            return (String[]) obj;
        } else { // obj가 String 또는 String[] 타입이 아닌 경우
            throw new IllegalArgumentException("Invalid input type for 'to'. Expected String or String[].");
        }
    }

    /**
     * 이메일 전송 - SimpleMailMessage 사용 - 텍스트 포맷만 가능
     * 
     * 주어진 수신자 배열, 제목 배열, 내용 배열을 바탕으로 이메일을 전송
     * 수신자, 제목, 내용은 각각 동일한 인덱스에서 매칭되며, 제목이나 내용이 하나만 제공될 경우 모든 수신자에게 동일한 제목/내용이 발송
     *
     * @param toArray      (String[]) 수신자 이메일 주소 배열. 이메일을 보낼 대상의 이메일 주소가 포함된 배열.
     * @param subjectArray (String[]) 이메일 제목 배열. 각 수신자에게 발송될 이메일 제목을 포함하는 배열.
     * @param textArray    (String[]) 이메일 내용 배열. 각 수신자에게 발송될 이메일 내용을 포함하는 배열.
     * @param html         (Boolean)이메일 내용이 HTML 포맷인 경우 {@code true}, 텍스트 포맷인 경우
     *                     {@code false}.
     * @param i            (int)현재 처리 중인 수신자의 인덱스. 각 배열에서 해당 수신자에 대한 제목과 내용을 추출
     * 
     * @throws Exception 이메일 전송 중 발생할 수 있는 모든 예외를 처리.
     * 
     * @return void
     */
    public void sendMail(String[] toArray, String[] subjectArray, String[] textArray, int i)
            throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();

        // 받는 사람
        message.setTo(toArray[i]);
        // 제목
        message.setSubject(subjectArray.length == 1 ? subjectArray[0] : subjectArray[i]);
        // 내용, html 여부
        message.setText(textArray.length == 1 ? textArray[0] : textArray[i]);

        // 이메일 전송
        mailSender.send(message);
    }

    /**
     * 이메일 전송 - MimeMessageHelper 사용 HTML 포맷
     * 
     * 주어진 수신자 배열, 제목 배열, 내용 배열을 바탕으로 이메일을 전송
     * 수신자, 제목, 내용은 각각 동일한 인덱스에서 매칭되며, 제목이나 내용이 하나만 제공될 경우 모든 수신자에게 동일한 제목/내용이 발송
     *
     * @param toArray      (String[]) 수신자 이메일 주소 배열. 이메일을 보낼 대상의 이메일 주소가 포함된 배열.
     * @param subjectArray (String[]) 이메일 제목 배열. 각 수신자에게 발송될 이메일 제목을 포함하는 배열.
     * @param textArray    (String[]) 이메일 내용 배열. 각 수신자에게 발송될 이메일 내용을 포함하는 배열.
     * @param html         (Boolean)이메일 내용이 HTML 포맷인 경우 {@code true}, 텍스트 포맷인 경우
     *                     {@code false}.
     * @param i            (int)현재 처리 중인 수신자의 인덱스. 각 배열에서 해당 수신자에 대한 제목과 내용을 추출
     * 
     * @throws Exception 이메일 전송 중 발생할 수 있는 모든 예외를 처리.
     * 
     * @return void
     */
    public void sendMail(String[] toArray, String[] subjectArray, String[] textArray, Boolean html, int i)
            throws Exception {
        MimeMessage message = mailSender.createMimeMessage(); // MimeMessage 객체 생성
        // MimeMessage를 쉽게 다룰 수 있도록 도와주는 유틸 클래스
        // 첫번째 매개변수 : MimeMessage 객체 || 두번째 매개변수 : Multipart 이메일 활성화 여부
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // 받는 사람
        helper.setTo(toArray[i]);
        // 제목
        helper.setSubject(subjectArray.length == 1 ? subjectArray[0] : subjectArray[i]);
        // 내용, html 여부
        helper.setText(textArray.length == 1 ? textArray[0] : textArray[i], html);

        // 이메일 전송
        mailSender.send(message);
    }

    /**
     * 이메일 전송 - MimeMessageHelper 사용 HTML, file 포맷
     * 
     * 주어진 수신자 배열, 제목 배열, 내용 배열을 바탕으로 이메일을 전송
     * 수신자, 제목, 내용은 각각 동일한 인덱스에서 매칭되며, 제목이나 내용이 하나만 제공될 경우 모든 수신자에게 동일한 제목/내용이 발송
     *
     * @param toArray      (String[]) 수신자 이메일 주소 배열. 이메일을 보낼 대상의 이메일 주소가 포함된 배열.
     * @param subjectArray (String[]) 이메일 제목 배열. 각 수신자에게 발송될 이메일 제목을 포함하는 배열.
     * @param textArray    (String[]) 이메일 내용 배열. 각 수신자에게 발송될 이메일 내용을 포함하는 배열.
     * @param html         (Boolean)이메일 내용이 HTML 포맷인 경우 {@code true}, 텍스트 포맷인 경우
     *                     {@code false}.
     * @param fileName     (String) 첨부파일 이름. 미입력 시 file에서 파일명 추출
     * @param file         (File) 첨부파일
     * @param i            (int)현재 처리 중인 수신자의 인덱스. 각 배열에서 해당 수신자에 대한 제목과 내용을 추출
     * 
     * @throws Exception 이메일 전송 중 발생할 수 있는 모든 예외를 처리.
     * 
     * @return void
     */
    public void sendMail(String[] toArray, String[] subjectArray, String[] textArray, Boolean html, String fileName,
            File file, int idx)
            throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // 받는 사람
        helper.setTo(toArray[idx]);
        // 제목
        helper.setSubject(subjectArray.length == 1 ? subjectArray[0] : subjectArray[idx]);
        // 내용, html 여부
        helper.setText(textArray.length == 1 ? textArray[0] : textArray[idx], html);

        // 첨부파일 추가 (fileName이 존재하지 않으면 file에서 파일명 추출)
        String attachmentName = (fileName != null && !fileName.trim().isEmpty()) ? fileName : file.getName();
        helper.addAttachment(attachmentName, file);

        // 이메일 전송
        mailSender.send(message);
    }

    /**
     * 이메일을 전송하기 전 수신자, 제목, 내용을 확인하고 이메일 전송 메서드를 호출 - 비동기 처리
     * 
     * 입력받은 데이터에 대한 타입 변환, 유효성 검사를 수행
     * 반복문으로 이메일 전송 메서드를 호출
     *
     * @param to       (Object) 수신자 이메일 주소 배열. 이메일을 보낼 대상의 이메일 주소가 포함된 배열.
     * @param subject  (Object) 이메일 제목 배열. 각 수신자에게 발송될 이메일 제목을 포함하는 배열.
     * @param text     (Object) 이메일 내용 배열. 각 수신자에게 발송될 이메일 내용을 포함하는 배열.
     * @param html     (Boolean)이메일 내용이 HTML 포맷인 경우 {@code true}, 텍스트 포맷인 경우
     *                 {@code false}.
     * @param fileName (String) 첨부파일 이름. 미입력 시 file에서 파일명 추출
     * @param file     (File) 첨부파일
     * 
     * @throws Exception 이메일 전송 중 발생할 수 있는 모든 예외를 처리.
     * 
     * @return CompletableFuture<Integer> 비동기로 보낸 횟수 반환
     */
    @Async // AsyncConfig 파일 참조
    public CompletableFuture<Integer> sendMail(Object to, Object subject, Object text, Boolean html, String fileName,
            File file)
            throws Exception {

        // 'to', 'subject', 'text'가 String 또는 String[]일 수 있음
        String[] toArray = convertObjectToArray(to); // 수신자 배열로 변환
        String[] subjectArray = convertObjectToArray(subject); // 제목 배열로 변환
        String[] textArray = convertObjectToArray(text); // 내용 배열로 변환

        // 수신자보다 제목, 내용이 많으면 에러
        if (toArray.length < subjectArray.length || toArray.length < textArray.length)
            throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);

        // 수신자가 여러명일 때 수신자보다 제목, 내용이 많거나 적으면(1제외) 에러
        if (toArray.length > 1) {
            if (toArray.length < subjectArray.length || toArray.length < textArray.length)
                throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);
            if ((toArray.length > subjectArray.length && subjectArray.length != 1)
                    || (toArray.length > textArray.length && textArray.length != 1))
                throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);
        }

        // html 값이 null이면 기본값 : true
        if (html == null)
            html = true;

        // 반복문으로 이메일 발송
        int sentCount = 0; // 보낸 횟수
        for (int i = 0; i < toArray.length; i++) {
            // 이메일 전송 메소드 호출
            if (file != null && file.exists()) // 첨부파일이 있는 경우
                sendMail(toArray, subjectArray, textArray, html, fileName, file, i);
            else // 첨부파일이 없는 경우
                sendMail(toArray, subjectArray, textArray, html, i);

            sentCount++;
        }
        return CompletableFuture.completedFuture(sentCount); // 비동기로 보낸 횟수 반환
    }

    /**
     * 이메일을 전송하기 전 수신자, 제목, 내용을 확인하고 이메일 전송 메서드를 호출 - 비동기 처리, 배치 처리
     * 
     * 입력받은 데이터에 대한 타입 변환, 유효성 검사를 수행
     * 배치 방식으로 이메일 전송 메서드를 호출
     *
     * @param to        (Object) 수신자 이메일 주소 배열. 이메일을 보낼 대상의 이메일 주소가 포함된 배열.
     * @param subject   (Object) 이메일 제목 배열. 각 수신자에게 발송될 이메일 제목을 포함하는 배열.
     * @param text      (Object) 이메일 내용 배열. 각 수신자에게 발송될 이메일 내용을 포함하는 배열.
     * @param html      (Boolean)이메일 내용이 HTML 포맷인 경우 {@code true}, 텍스트 포맷인 경우
     *                  {@code false}.
     * @param fileName  (String) 첨부파일 이름. 미입력 시 file에서 파일명 추출
     * @param file      (File) 첨부파일
     * @param batchSize (int) 배치 크기. 기본값은 100
     * 
     * @throws Exception 이메일 전송 중 발생할 수 있는 모든 예외를 처리.
     * 
     * @return ListenableFuture<Integer> 비동기로 보낸 횟수 반환
     */
    @Async // AsyncConfig 파일 참조
    public CompletableFuture<Integer> sendMail(Object to, Object subject, Object text, Boolean html, String fileName,
            File file, int batchSize)
            throws Exception {
        // 'to', 'subject', 'text'가 String 또는 String[]일 수 있음
        String[] toArray = convertObjectToArray(to); // 수신자 배열로 변환
        String[] subjectArray = convertObjectToArray(subject); // 제목 배열로 변환
        String[] textArray = convertObjectToArray(text); // 내용 배열로 변환

        // 수신자보다 제목, 내용이 많으면 에러
        if (toArray.length < subjectArray.length || toArray.length < textArray.length)
            throw new CustomRuntimeException(BizErrorCode.MAIL_DATA_NOT_FOUND);

        // html 값이 null이면 기본값 : true
        if (html == null)
            html = true;

        // batchSize 값이 null 또는 0이면 기본값 : 100
        if (batchSize == 0)
            batchSize = 100;

        int totalRecipients = toArray.length; // 전체 수신자 수
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10개의 스레드를 사용

        // 작업을 배치 크기별로 분할하여 병렬 처리
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < totalRecipients; i++) {
            final int index = i;
            final Boolean htmlFinal = html; // final로 html을 복사

            // 작업 목록에 추가
            tasks.add(() -> {
                // 이메일 전송 메소드 호출
                if (file != null && file.exists()) // 첨부파일이 있는 경우
                    sendMail(toArray, subjectArray, textArray, htmlFinal, fileName, file, index);
                else // 첨부파일이 없는 경우
                    sendMail(toArray, subjectArray, textArray, htmlFinal, index);
                return null;
            });

            // 배치 크기만큼 작업을 분배하여 처리
            if ((i + 1) % batchSize == 0 || i == totalRecipients - 1) {
                // 제출한 작업들을 병렬로 실행
                List<Future<Void>> futures = executorService.invokeAll(tasks);
                for (Future<Void> future : futures) {
                    future.get(); // 결과 대기 (작업이 완료될 때까지)
                }
                tasks.clear(); // 작업 목록 초기화
            }
        }

        // 작업 완료 후 종료
        executorService.shutdown(); // 더 이상 새로운 작업을 받지 않도록 종료
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) // 최대 60초 대기
            executorService.shutdownNow(); // 강제로 종료

        // 전체 전송된 메일 수 반환
        return CompletableFuture.completedFuture(totalRecipients); // 비동기로 보낸 횟수 반환
    }
}
