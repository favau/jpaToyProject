package com.fav.fav.common.data;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // Spring 통합을 위한 설정
public interface BaseMapper {

    // 공통 필드를 후처리 메서드에서 설정
    @AfterMapping
    default void setCommonFields(@MappingTarget BaseEntity target, BaseDto source) {
        if (target != null && source != null) {
            // 공통 필드 매핑
            target.setStatus(source.getStatus());
            target.setCreateBy(source.getCreateBy());
            target.setCreateAt(source.getCreateAt());
            target.setUpdateBy(source.getUpdateBy());
            target.setUpdateAt(source.getUpdateAt());
        }
    }

    // BaseEntity → BaseDto 변환
    // count, page, size는 매핑하지 않도록 설정
    @Mapping(target = "count", ignore = true)
    @Mapping(target = "page", ignore = true)
    @Mapping(target = "size", ignore = true)
    BaseDto entityToDto(BaseEntity entity);

    // BaseDto → BaseEntity 변환
    BaseEntity dtoToEntity(BaseDto dto);
}