package com.fav.fav.project1.mybatisExample.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fav.fav.common.data.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter 메소드를 자동으로 생성
@Setter // Setter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisExampleEntity extends BaseEntity {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Gender gender;
    private String address;
    private int isActive;

    // 성별 Enum 정의
    public enum Gender {
        M, F, U // 남성, 여성, 기타
    }
}
