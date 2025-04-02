package com.fav.fav.project1.jooqExample.data;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data	// Getter, Setter, toString, equals, hashCode를 자동으로 생성
@SuperBuilder(toBuilder = true)	// Builder, toBuilder를 사용할 수 있게 해줌
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class JooqExampleModel {

	@NotEmpty(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    // 비밀번호 유효성 검사 비즈니스 로직
    // public boolean isValidPassword() {
    //     if (password == null || password.isEmpty()) {
    //         return false;
    //     }
        
    //     // 최소 8자, 최대 20자
    //     // 최소 하나의 대문자, 소문자, 숫자, 특수문자 포함
    //     String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    //     return Pattern.matches(regex, password);
    // }
    
    // // 비밀번호 암호화 로직
    // public void encryptPassword() throws NoSuchAlgorithmException {
    //     if (!isPasswordEncrypted && password != null) {
    //         MessageDigest md = MessageDigest.getInstance("SHA-256");
    //         byte[] hash = md.digest(password.getBytes());
    //         this.password = Base64.getEncoder().encodeToString(hash);
    //         this.isPasswordEncrypted = true;
    //     }
    // }
    
    // // 비밀번호 일치 여부 확인 로직
    // public boolean matchPassword(String inputPassword) throws NoSuchAlgorithmException {
    //     if (isPasswordEncrypted) {
    //         // 입력된 비밀번호를 암호화하여 비교
    //         MessageDigest md = MessageDigest.getInstance("SHA-256");
    //         byte[] inputHash = md.digest(inputPassword.getBytes());
    //         String encryptedInput = Base64.getEncoder().encodeToString(inputHash);
    //         return this.password.equals(encryptedInput);
    //     } else {
    //         // 암호화되지 않은 경우 직접 비교
    //         return this.password.equals(inputPassword);
    //     }
    // }
    
    // // 비즈니스 요구사항에 따른 비밀번호 정책 체크
    // public String getPasswordStrength() {
    //     if (password == null || password.isEmpty()) {
    //         return "Empty";
    //     }
        
    //     int score = 0;
        
    //     // 길이에 따른 점수
    //     if (password.length() >= 12) score += 2;
    //     else if (password.length() >= 8) score += 1;
        
    //     // 대소문자 혼합 점수
    //     if (Pattern.matches(".*[A-Z].*", password)) score += 1;
    //     if (Pattern.matches(".*[a-z].*", password)) score += 1;
        
    //     // 숫자 포함 점수
    //     if (Pattern.matches(".*\\d.*", password)) score += 1;
        
    //     // 특수문자 포함 점수
    //     if (Pattern.matches(".*[@$!%*?&].*", password)) score += 1;
        
    //     // 점수에 따른 강도 반환
    //     if (score >= 5) return "Strong";
    //     else if (score >= 3) return "Medium";
    //     else return "Weak";
    // }
}
