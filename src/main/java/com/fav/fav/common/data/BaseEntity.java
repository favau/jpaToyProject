package com.fav.fav.common.data;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

// import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity // JPA Entity임을 나타냄
@Getter // Getter 메소드를 자동으로 생성
@Setter // Setter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
public class BaseEntity {
    private String status;
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private ZonedDateTime createAt;
    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private ZonedDateTime updateAt;

}
