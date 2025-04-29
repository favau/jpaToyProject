package com.jpaToyProject.api.project1.mybatisExample.modelCase.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.jpaToyProject.api.project1.mybatisExample.modelCase.data.MybatisModelCaseEntity;
import com.jpaToyProject.api.project1.mybatisExample.modelCase.data.MybatisModelCaseRequestDto;

@Mapper
public interface MybatisModelCaseMapper {

    List<MybatisModelCaseEntity> read (MybatisModelCaseRequestDto requestDto);

}