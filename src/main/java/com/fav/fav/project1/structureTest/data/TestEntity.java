package com.fav.fav.project1.structureTest.data;

import com.fav.fav.common.data.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA Entity임을 나타냄
@Table(name = "test") // 'test' 테이블과 매핑됨을 나타냄
@Getter // Getter 메소드를 자동으로 생성
@Setter // Setter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
public class TestEntity extends BaseEntity {

    @Id // Primary Key임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key의 값을 자동으로 생성 GenerationType.IDENTITY는 DB의 자동 증가
                                                        // 번호를 사용
    private Long id;
    private String name;
    private String email;
    private String password;
}
