package com.fav.fav.project1.jooqExample.data;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Value      // 불변 객체 생성. private 속성 추가
@Builder	// Builder를 사용할 수 있게 해줌
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class JooqExampleVo{

    Long id;
    String name;
    String email;
}
