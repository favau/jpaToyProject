package com.fav.fav.common.data;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

public interface BaseMapper<D extends BaseDto, E extends BaseEntity> {

    // 공통 필드를 후처리 메서드에서 설정
    @AfterMapping
    default void setCommonFields(@MappingTarget E target, D source) {
        if (target != null && source != null) {
            // 공통 필드 매핑
            target.setStatus(source.getStatus());
            target.setCreateBy(source.getCreateBy());
            target.setCreateAt(source.getCreateAt());
            target.setUpdateBy(source.getUpdateBy());
            target.setUpdateAt(source.getUpdateAt());
        }
    }

    // BaseDto → BaseEntity 변환
    E dtoToEntity(D dto);

    // BaseEntity → BaseDto 변환
    D entityToDto(E entity);
}