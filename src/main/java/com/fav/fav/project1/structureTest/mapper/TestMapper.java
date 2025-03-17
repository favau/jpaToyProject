package com.fav.fav.project1.structureTest.mapper;

import com.fav.fav.common.data.BaseMapper;
import com.fav.fav.project1.structureTest.data.TestEntity;
import com.fav.fav.project1.structureTest.data.TestRequestDto;
import com.fav.fav.project1.structureTest.data.TestResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper {
    // RequestDto -> Entity 매핑을 위한 인터페이스
    interface RequestMapper extends BaseMapper<TestRequestDto, TestEntity> {
        @Override
        @Mapping(target = "password", source = "testModel.password")
        @Mapping(target = "id", source = "testVo.id")
        @Mapping(target = "name", source = "testVo.name")
        @Mapping(target = "email", source = "testVo.email")
        TestEntity dtoToEntity(TestRequestDto dto);
    }
    
    // Entity -> ResponseDto 매핑을 위한 인터페이스
    interface ResponseMapper extends BaseMapper<TestResponseDto, TestEntity> {
        @Override
        @Mapping(target = "testVo.id", source = "id")
        @Mapping(target = "testVo.name", source = "name")
        @Mapping(target = "testVo.email", source = "email")
        @Mapping(target = "testModel.password", source = "password")
        TestResponseDto entityToDto(TestEntity entity);
    }
}