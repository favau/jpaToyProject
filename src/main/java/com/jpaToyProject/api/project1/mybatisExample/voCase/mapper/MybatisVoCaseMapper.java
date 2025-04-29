package com.jpaToyProject.api.project1.mybatisExample.voCase.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseEntity;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseRequestDto;

@Mapper
public interface MybatisVoCaseMapper {

    List<MybatisVoCaseEntity> read (MybatisVoCaseRequestDto requestDto);

}