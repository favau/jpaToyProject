package com.jpaToyProject.api.project1.mybatisExample.voCase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpaToyProject.api.common.data.BaseService;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseEntity;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseRequestDto;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseResponseDto;
import com.jpaToyProject.api.project1.mybatisExample.voCase.data.MybatisVoCaseVo;
import com.jpaToyProject.api.project1.mybatisExample.voCase.mapper.MybatisVoCaseMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MybatisVoCaseService implements BaseService<MybatisVoCaseResponseDto, MybatisVoCaseRequestDto> {
    private final MybatisVoCaseMapper testMapper;

    @Override
    public int create(MybatisVoCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<MybatisVoCaseResponseDto> read(MybatisVoCaseRequestDto requestDto) throws Exception {
        // DB에서 데이터 조회
        List<MybatisVoCaseEntity> entities = testMapper.read(requestDto);
        if (entities.isEmpty()) {
            return List.of(); // 빈 리스트 반환
        }
        // entity ==> vo ==> responseDto 변환
        List<MybatisVoCaseResponseDto> responseDto = entities.stream()
                .map(entity -> {
                    
                    MybatisVoCaseVo vo = MybatisVoCaseVo
                            .builder()
                            .zipCode(entity.getZipCode())
                            .address1(entity.getAddress1())
                            .address2(entity.getAddress2())
                            .build();

                    String fullAddress = vo.getFullAddress();

                    // 최종 ResponseDto 생성 및 반환
                    return MybatisVoCaseResponseDto
                            .builder()
                            .fullAddress(fullAddress)
                            .build();
                })
                .collect(Collectors.toList());

        return responseDto;
    }

    @Override
    public int update(MybatisVoCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(MybatisVoCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<MybatisVoCaseResponseDto> readPage(MybatisVoCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readPage'");
    }

    @Override
    public long count(MybatisVoCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
}
