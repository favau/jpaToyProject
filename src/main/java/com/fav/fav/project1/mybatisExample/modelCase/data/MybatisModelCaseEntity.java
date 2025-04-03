package com.fav.fav.project1.mybatisExample.modelCase.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fav.fav.common.data.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter 메소드를 자동으로 생성
@Setter // Setter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisModelCaseEntity extends BaseEntity {

    private Long id;
    private String name;
    private int itemPrice;
    private int itemCount;
    private int shippingFee;
    private int discount;

}
