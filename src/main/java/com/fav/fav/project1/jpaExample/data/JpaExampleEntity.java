// package com.fav.fav.project1.jpaExample.data;

// import com.fasterxml.jackson.annotation.JsonInclude;
// import com.fav.fav.common.data.BaseEntity;

// import jakarta.persistence.Column;
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
// public class JpaExampleEntity extends BaseEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private Long id;
//     @Column(name = "name", nullable = true, length = 50)
//     private String name;
//     @Column(name = "login_id", nullable = false, length = 100)
//     private String loginId;
//     @Column(name = "password", nullable = false, unique = true, length = 100)
//     private String password;
//     @Column(name = "email", nullable = true, unique = true, length = 100)
//     private String email;
//     @Column(name = "phone_number", nullable = false, unique = true, length = 20)
//     private String phoneNumber;
//     @Column(name = "birth_date", nullable = true, length = 10)
//     private String birthDate;
//     @Column(name = "gender", nullable = true, length = 1)
//     private Gender gender;
//     @Column(name = "address", nullable = true, length = 200)
//     private String address;
//     @Column(name = "is_active", length = 1)
//     private int isActive;

//     // 성별 Enum 정의
//     public enum Gender {
//         M, F, U // 남성, 여성, 기타
//     }
// }
