// package com.fav.fav.project1.jooqExample.mapper;

// import org.mapstruct.AfterMapping;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.MappingTarget;

// import com.fav.fav.project1.jooqExample.data.JooqExampleEntity;
// import com.fav.fav.project1.jooqExample.data.JooqExampleRequestDto;
// import com.fav.fav.project1.jooqExample.data.JooqExampleResponseDto;

// @Mapper(componentModel = "spring")
// public interface JooqExampleMapper {
//     // 요청 DTO → 엔티티 변환
//     @Mapping(target = "password", source = "testModel.password")
//     @Mapping(target = "id", source = "testVo.id")
//     @Mapping(target = "name", source = "testVo.name")
//     @Mapping(target = "email", source = "testVo.email")
//     JooqExampleEntity requestToEntity(JooqExampleRequestDto dto);

//     // 엔티티 → 응답 DTO 변환
//     @Mapping(target = "testVo.id", source = "id")
//     @Mapping(target = "testVo.name", source = "name")
//     @Mapping(target = "testVo.email", source = "email")
//     @Mapping(target = "testModel.password", source = "password")
//     @Mapping(target = "count", ignore = true)
//     @Mapping(target = "page", ignore = true)
//     @Mapping(target = "size", ignore = true)
//     JooqExampleResponseDto entityToResponse(JooqExampleEntity entity);

//     // 공통 필드 설정 AfterMapping은 매핑이 끝난 후에 실행
//     @AfterMapping
//     default void setCommonFields(@MappingTarget JooqExampleEntity entity, JooqExampleRequestDto dto) {
//         if (entity != null && dto != null) {
//             entity.setStatus(dto.getStatus());
//             entity.setCreateBy(dto.getCreateBy());
//             entity.setCreateAt(dto.getCreateAt());
//             entity.setUpdateBy(dto.getUpdateBy());
//             entity.setUpdateAt(dto.getUpdateAt());
//         }
//     }
// }