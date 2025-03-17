package com.fav.fav.common.data;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Getter, Setter, toString, equals, hashCode를 자동으로 생성
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BaseDto {

    // 페이징
    private Integer page; // 0부터 시작
    private Integer size;
    private Long count;

    // 공통 컬럼
    private String status;
    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private ZonedDateTime createAt;
    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private ZonedDateTime updateAt;
}
