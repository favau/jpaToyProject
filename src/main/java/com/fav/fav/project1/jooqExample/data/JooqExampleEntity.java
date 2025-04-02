// package com.fav.fav.project1.jooqExample.data;

// import com.fasterxml.jackson.annotation.JsonInclude;
// import com.fav.fav.common.data.BaseEntity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity // JPA Entity임을 나타냄
// @Table(name = "test") // 'test' 테이블과 매핑됨을 나타냄
// @Getter // Getter 메소드를 자동으로 생성
// @Setter // Setter 메소드를 자동으로 생성
// @NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
// @JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
// public class JooqExampleEntity extends BaseEntity {

//     @Id // Primary Key임을 나타냄
//     // Primary Key의 값을 자동으로 생성
//     // GenerationType.IDENTITY는 DB의 자동 증가 번호를 사용
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private String email;
//     private String password;
// }
