package com.fav.fav.project1.structureTest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fav.fav.common.BaseService;
import com.fav.fav.project1.structureTest.data.TestEntity;
import com.fav.fav.project1.structureTest.data.TestRequestDto;
import com.fav.fav.project1.structureTest.data.TestResponseDto;
import com.fav.fav.project1.structureTest.mapper.TestMapper;
import com.fav.fav.project1.structureTest.repository.TestRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService implements BaseService<TestResponseDto, TestRequestDto> {
    @Autowired
    public final TestRepository testRepository;

    @Override
    public int create(TestRequestDto requestDto) throws Exception {
        int affected = 0;

        TestEntity entity = TestMapper.INSTANCE.requestDtoToEntity(requestDto); // MapStruct 활용
        TestEntity resultEntity = testRepository.save(entity);
        TestResponseDto responseDto = TestMapper.INSTANCE.entityToResponseDto(resultEntity);
        // if (affected != 1)
        // throw new BusinessException(BizErrorCode.DATA_NOT_FOUND_CREATE);

        return affected;
    }

    @Override
    public List<TestResponseDto> read(TestRequestDto requestDto) throws Exception {
        TestEntity entity = TestMapper.INSTANCE.requestDtoToEntity(requestDto);
        List<TestEntity> result = testRepository.read(entity);

        return result.stream()
                .map(TestMapper.INSTANCE::entityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public int update(TestRequestDto requestDto) throws Exception {
        return 0;
    }

    @Override
    public int delete(TestRequestDto requestDto) throws Exception {
        return 0;
    }
}
