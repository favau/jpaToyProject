package com.fav.fav.project1.mybatisExample.modelCase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fav.fav.common.data.BaseService;
import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseEntity;
import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseModel;
import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseRequestDto;
import com.fav.fav.project1.mybatisExample.modelCase.data.MybatisModelCaseResponseDto;
import com.fav.fav.project1.mybatisExample.modelCase.mapper.MybatisModelCaseMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MybatisModelCaseService implements BaseService<MybatisModelCaseResponseDto, MybatisModelCaseRequestDto> {
    private final MybatisModelCaseMapper testMapper;

    @Override
    public int create(MybatisModelCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<MybatisModelCaseResponseDto> read(MybatisModelCaseRequestDto requestDto) throws Exception {
        List<MybatisModelCaseEntity> entities = testMapper.read(requestDto);

        List<MybatisModelCaseResponseDto> responseDto = entities.stream()
                .map(entity -> {
                    MybatisModelCaseModel model = MybatisModelCaseModel.builder()
                            .name(entity.getName())
                            .itemPrice(entity.getItemPrice())
                            .itemCount(entity.getItemCount())
                            .shippingFee(entity.getShippingFee())
                            .discount(entity.getDiscount())
                            .build();

                    // 비즈니스 로직 호출
                    int totalPrice = model.getTotalPrice();

                    // 최종 ResponseDto 생성 및 반환
                    return MybatisModelCaseResponseDto
                            .builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .itemPrice(entity.getItemPrice())
                            .itemCount(entity.getItemCount())
                            .shippingFee(entity.getShippingFee())
                            .discount(entity.getDiscount())
                            .totalPrice(totalPrice)
                            .build();
                })
                .collect(Collectors.toList());

        return responseDto;
    }

    @Override
    public int update(MybatisModelCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(MybatisModelCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<MybatisModelCaseResponseDto> readPage(MybatisModelCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readPage'");
    }

    @Override
    public long count(MybatisModelCaseRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
}
