// package com.fav.fav.project1.querydslExample.mapper;

// import com.fav.fav.project1.querydslExample.data.QuerydlsExampleEntity;
// import com.fav.fav.project1.querydslExample.data.QuerydlsExampleRequestDto;
// import com.fav.fav.project1.querydslExample.data.QuerydlsExampleResponseDto;

// import org.mapstruct.AfterMapping;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.MappingTarget;

// @Mapper(componentModel = "spring")
// public interface QuerydlsExampleMapper {
//     // 요청 DTO → 엔티티 변환
//     @Mapping(target = "password", source = "testModel.password")
//     @Mapping(target = "id", source = "testVo.id")
//     @Mapping(target = "name", source = "testVo.name")
//     @Mapping(target = "email", source = "testVo.email")
//     QuerydlsExampleEntity requestToEntity(QuerydlsExampleRequestDto dto);

//     // 엔티티 → 응답 DTO 변환
//     @Mapping(target = "testVo.id", source = "id")
//     @Mapping(target = "testVo.name", source = "name")
//     @Mapping(target = "testVo.email", source = "email")
//     @Mapping(target = "testModel.password", source = "password")
//     @Mapping(target = "count", ignore = true)
//     @Mapping(target = "page", ignore = true)
//     @Mapping(target = "size", ignore = true)
//     QuerydlsExampleResponseDto entityToResponse(QuerydlsExampleEntity entity);

//     // 공통 필드 설정 AfterMapping은 매핑이 끝난 후에 실행
//     @AfterMapping
//     default void setCommonFields(@MappingTarget QuerydlsExampleEntity entity, QuerydlsExampleRequestDto dto) {
//         if (entity != null && dto != null) {
//             entity.setStatus(dto.getStatus());
//             entity.setCreateBy(dto.getCreateBy());
//             entity.setCreateAt(dto.getCreateAt());
//             entity.setUpdateBy(dto.getUpdateBy());
//             entity.setUpdateAt(dto.getUpdateAt());
//         }
//     }
// }