package com.fav.fav.project1.mybatisExample.voCase.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.fav.fav.project1.mybatisExample.voCase.data.MybatisVoCaseEntity;
import com.fav.fav.project1.mybatisExample.voCase.data.MybatisVoCaseRequestDto;

@Mapper
public interface MybatisVoCaseMapper {

    List<MybatisVoCaseEntity> read (MybatisVoCaseRequestDto requestDto);

}