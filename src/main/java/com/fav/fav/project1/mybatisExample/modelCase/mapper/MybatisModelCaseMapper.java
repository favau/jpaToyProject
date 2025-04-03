package com.fav.fav.project1.mybatisExample.modelCase.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseEntity;
import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseRequestDto;

@Mapper
public interface MybatisModelCaseMapper {

    List<MybatisModelCaseEntity> read (MybatisModelCaseRequestDto requestDto);

}