package com.jpaToyProject.api.project1.mybatisExample.modelCase.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpaToyProject.api.common.data.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Getter, Setter, toString, equals, hashCode를 자동으로 생성
@EqualsAndHashCode(callSuper = false) // 상속받은 클래스의 필드를 제외하고 equals, hashCode를 생성
@SuperBuilder(toBuilder = true) // Builder, toBuilder를 사용할 수 있게 해줌
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 제외하고 JSON으로 변환
public class MybatisModelCaseModel extends BaseModel {

    private String name;
    private int itemPrice;
    private int itemCount;
    private int shippingFee;
    private int discount;

    public int getTotalPrice() {
        // 총 가격 계산 로직
        return itemPrice * itemCount + shippingFee - discount;
    }
}
