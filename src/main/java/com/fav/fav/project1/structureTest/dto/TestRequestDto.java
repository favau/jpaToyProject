package com.fav.fav.project1.structureTest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data	// Getter, Setter, toString, equals, hashCode를 자동으로 생성
@SuperBuilder(toBuilder = true)	// Builder, toBuilder를 사용할 수 있게 해줌
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
public class TestRequestDto {
    
    private String id;
    private String name;
}