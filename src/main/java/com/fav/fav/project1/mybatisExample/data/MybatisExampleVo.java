package com.fav.fav.project1.mybatisExample.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleEntity.Gender;

import lombok.Builder;
import lombok.Value;

@Value // 불변 객체 생성. private 속성 추가
@Builder // Builder를 사용할 수 있게 해줌
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisExampleVo {

    Long id;
    String name;
    private String birthDate;
    private Gender gender;
    private String address;
    private int isActive;

}
