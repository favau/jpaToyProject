package com.fav.fav.project1.structureTest.data;

import lombok.Builder;
import lombok.Value;

@Value      // 불변 객체 생성. private 속성 추가
@Builder	// Builder를 사용할 수 있게 해줌
public class TestVo{

    Long id;
    String name;
    String email;
}
