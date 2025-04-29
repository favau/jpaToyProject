package com.jpaToyProject.api.project1.mybatisExample.voCase.data;

import com.jpaToyProject.api.common.data.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Getter, Setter, toString, equals, hashCode를 자동으로 생성
@EqualsAndHashCode(callSuper = false) // 상속받은 클래스의 필드를 제외하고 equals, hashCode를 생성
@SuperBuilder(toBuilder = true) // Builder, toBuilder를 사용할 수 있게 해줌
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
public class MybatisVoCaseRequestDto extends BaseDto {

    private Long id;
}