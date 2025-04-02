package com.fav.fav.project1.mybatisExample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fav.fav.common.data.BaseService;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleEntity;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleModel;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleRequestDto;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleResponseDto;
import com.fav.fav.project1.mybatisExample.data.MybatisExampleVo;
import com.fav.fav.project1.mybatisExample.mapper.MybatisExampleMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MybatisExampleService implements BaseService<MybatisExampleResponseDto, MybatisExampleRequestDto> {
    private final MybatisExampleMapper testMapper;

    @Override
    public List<MybatisExampleResponseDto> read(MybatisExampleRequestDto requestDto) throws Exception {
        List<MybatisExampleEntity> entities = testMapper.read(requestDto);

        List<MybatisExampleResponseDto> responseDto = entities.stream()
                .map(entity -> {
                    // VO 객체 생성
                    MybatisExampleVo vo = MybatisExampleVo
                            .builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .birthDate(entity.getBirthDate())
                            .gender(entity.getGender())
                            .address(entity.getAddress())
                            .isActive(entity.getIsActive())
                            .build();
                    // 필요한 다른 VO 필드 설정

                    // Model 객체 생성
                    MybatisExampleModel model = MybatisExampleModel
                            .builder()
                            .password(entity.getPassword())
                            .email(entity.getEmail())
                            .phoneNumber(entity.getPhoneNumber())
                            .status(entity.getStatus())
                            .createBy(entity.getCreateBy())
                            .createAt(entity.getCreateAt())
                            .updateBy(entity.getUpdateBy())
                            .updateAt(entity.getUpdateAt())
                            .build();
                    // 필요한 다른 Model 필드 설정

                    // 최종 ResponseDto 생성 및 반환
                    return MybatisExampleResponseDto
                            .builder()
                            .exampleVo(vo)
                            .exampleModel(model)
                            .build();
                })
                .collect(Collectors.toList());

        return responseDto;
    }

    @Override
    public int create(MybatisExampleRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(MybatisExampleRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(MybatisExampleRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<MybatisExampleResponseDto> readPage(MybatisExampleRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'readPage'");
    }

    @Override
    public long count(MybatisExampleRequestDto requestDto) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}
