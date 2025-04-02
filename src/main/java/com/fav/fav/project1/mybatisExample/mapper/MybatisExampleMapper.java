package com.fav.fav.project1.mybatisExample.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.fav.fav.project1.mybatisExample.data.MybatisExampleEntity;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleRequestDto;

@Mapper
public interface MybatisExampleMapper {

    List<MybatisExampleEntity> read (MybatisExampleRequestDto requestDto);
}