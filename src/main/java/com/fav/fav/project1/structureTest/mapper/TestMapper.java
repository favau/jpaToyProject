package com.fav.fav.project1.structureTest.mapper;

import com.fav.fav.common.data.BaseMapper;
import com.fav.fav.project1.structureTest.data.TestEntity;
import com.fav.fav.project1.structureTest.data.TestRequestDto;
import com.fav.fav.project1.structureTest.data.TestResponseDto;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // RequestDto -> Entity -> ResponseDto 간의 매핑을 담당
public interface TestMapper extends BaseMapper {

    // TestRequestDto → TestEntity 변환
    @Mapping(target = "password", source = "testModel.password") // TestModel 안의 password
    @Mapping(target = "id", source = "testVo.id") // TestVo 안의 id
    @Mapping(target = "name", source = "testVo.name") // TestVo 안의 name
    @Mapping(target = "email", source = "testVo.email") // TestVo 안의 email
    TestEntity dtoToEntity(TestRequestDto dto);

    // TestEntity → TestResponseDto 변환
    @Mapping(target = "testVo.id", source = "id") // TestVo 안의 id
    @Mapping(target = "testVo.name", source = "name") // TestVo 안의 name
    @Mapping(target = "testVo.email", source = "email") // TestVo 안의 email
    @Mapping(target = "testModel.password", source = "password") // TestModel 안의 password
    TestResponseDto entityToDto(TestEntity entity);

    // 공통 필드 후처리
    @AfterMapping
    default void addCommonFields(@MappingTarget TestEntity entity, TestRequestDto dto) {
        // 추가적인 공통 필드 처리
        if (entity != null && dto != null) {
            entity.setStatus(dto.getStatus());
            entity.setCreateBy(dto.getCreateBy());
            entity.setCreateAt(dto.getCreateAt());
            entity.setUpdateBy(dto.getUpdateBy());
            entity.setUpdateAt(dto.getUpdateAt());
        }
    }
}