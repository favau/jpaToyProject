package com.fav.fav.project1.structureTest.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA Entity임을 나타냄
@Data	// Getter, Setter, toString, equals, hashCode를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
public class TestEntity {
    
    @Id // Primary Key임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key의 값을 자동으로 생성 GenerationType.IDENTITY는 DB의 자동 증가 번호를 사용
    private Long id;
    private String name;
    private String email;
    private String password;
}
