package com.jpaToyProject.api.common.data;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data // Getter, Setter, toString, equals, hashCode를 자동으로 생성
@SuperBuilder(toBuilder = true)
public class BaseDto {

    public BaseDto(){
		page = 0;								// 페이지가 0 이면 전체 출력
		recordSize = 10;
		pageSize = 10;
	};

    // 페이징
    private Integer page; // 0부터 시작
    private Integer recordSize;
    private int pageSize; 						// 화면 하단에 출력할 페이지 사이즈
}
