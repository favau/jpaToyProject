package com.fav.fav.common;

import com.fav.fav.project1.structureTest.data.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseMapper {
    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    // RequestDto → Entity 클라이언트에서 서버로 전송
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createAt", source = "createAt")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateAt", source = "updateAt")
    TestEntity requestDtoToEntity(TestRequestDto dto);

    // Entity → ResponseDto 서버에서 클라이언트로 전송
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createAt", source = "createAt")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateAt", source = "updateAt")
    TestResponseDto entityToResponseDto(TestEntity entity);
}