package com.jpaToyProject.api.project1.mybatisExample.voCase.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpaToyProject.api.common.data.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter 메소드를 자동으로 생성
@Setter // Setter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisVoCaseEntity extends BaseEntity {

    private Long id;
    private String zipCode;
    private String address1;
    private String address2;

    // 성별 Enum 정의
    public enum Gender {
        M, F, U // 남성, 여성, 기타
    }
}
