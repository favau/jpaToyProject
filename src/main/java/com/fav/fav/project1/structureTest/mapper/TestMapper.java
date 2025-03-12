package com.fav.fav.project1.structureTest.mapper;

import com.fav.fav.common.BaseMapper;
import com.fav.fav.project1.structureTest.data.TestEntity;
import com.fav.fav.project1.structureTest.data.TestRequestDto;
import com.fav.fav.project1.structureTest.data.TestResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper // RequestDto -> Entity -> ResponseDto 간의 매핑을 담당
public interface TestMapper extends BaseMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    // RequestDto → Entity 클라이언트에서 서버로 전송
    @Mapping(target = "id", ignore = true) // 보통 create에서는 id 제외
    @Mapping(target = "password", source = "testModel.password")
    @Mapping(target = "name", source = "testVo.name")
    @Mapping(target = "email", source = "testVo.email")
    TestEntity requestDtoToEntity(TestRequestDto dto);

    // Entity → ResponseDto 서버에서 클라이언트로 전송
    @Mapping(target = "testModel.password", source = "password")
    @Mapping(target = "testVo.id", expression = "java(String.valueOf(entity.getId()))")
    @Mapping(target = "testVo.name", source = "name")
    @Mapping(target = "testVo.email", source = "email")
    TestResponseDto entityToResponseDto(TestEntity entity);
}
