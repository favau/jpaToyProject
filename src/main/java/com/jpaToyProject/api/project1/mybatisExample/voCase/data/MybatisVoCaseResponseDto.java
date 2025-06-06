package com.jpaToyProject.api.project1.mybatisExample.voCase.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpaToyProject.api.common.data.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Getter, Setter, toString, equals, hashCode를 자동으로 생성
@SuperBuilder(toBuilder = true) // Builder, toBuilder를 사용할 수 있게 해줌
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@EqualsAndHashCode(callSuper = false) // 부모 클래스의 equals, hashCode 호출 안 함
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisVoCaseResponseDto extends BaseDto {

    private long id;
    private String zipCode;
    private String address1;
    private String address2;
    private String fullAddress;
}