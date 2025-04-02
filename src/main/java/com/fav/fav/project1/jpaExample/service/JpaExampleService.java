// package com.fav.fav.project1.jpaExample.service;

// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import com.fav.fav.common.data.BaseService;
// import com.fav.fav.project1.jpaExample.data.JpaExampleEntity;
// import com.fav.fav.project1.jpaExample.data.JpaExampleRequestDto;
// import com.fav.fav.project1.jpaExample.data.JpaExampleResponseDto;
// import com.fav.fav.project1.jpaExample.mapper.JpaExampleMapper;
// import com.fav.fav.project1.jpaExample.repository.JpaExampleRepository;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Service
// @RequiredArgsConstructor
// public class JpaExampleService implements BaseService<JpaExampleResponseDto, JpaExampleRequestDto> {

//     private final JpaExampleRepository testRepository;
//     private final JpaExampleMapper testMapper; // Spring이 주입

//     @Override
//     public int create(JpaExampleRequestDto requestDto) throws Exception {
//         JpaExampleEntity entity = testMapper.requestToEntity(requestDto);
//         testRepository.save(entity);
//         return 1;
//     }

//     @Override
//     public List<JpaExampleResponseDto> read(JpaExampleRequestDto requestDto) throws Exception {
//         Optional<JpaExampleEntity> result = testRepository.findById(requestDto.getTestVo().getId());
//         return result
//                 .map(entity -> List.of(testMapper.entityToResponse(entity)))
//                 .orElse(List.of());
//     }

//     @Override
//     public int update(JpaExampleRequestDto requestDto) throws Exception {
//         JpaExampleEntity entity = testMapper.requestToEntity(requestDto);
//         if (!testRepository.existsById(entity.getId())) {
//             throw new RuntimeException("해당 ID 없음");
//         }
//         testRepository.save(entity);
//         return 1;
//     }

//     @Override
//     public int delete(JpaExampleRequestDto requestDto) throws Exception {
//         Long id = requestDto.getTestVo().getId();
//         if (id != null && testRepository.existsById(id)) {
//             testRepository.deleteById(id);
//             return 1;
//         }
//         return 0;
//     }

//     @Override
//     public List<JpaExampleResponseDto> readPage(JpaExampleRequestDto requestDto) throws Exception {
//         int page = requestDto.getPage() != null ? requestDto.getPage() : 0;
//         int size = requestDto.getSize() != null ? requestDto.getSize() : 10;

//         Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
//         Page<JpaExampleEntity> result = testRepository.findAll(pageable);

//         return result.getContent().stream()
//                 .map(testMapper::entityToResponse)
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public long count(JpaExampleRequestDto requestDto) throws Exception {
//         // 단순 전체 count라면
//         long totalCount = testRepository.count();

//         // 조건부 count가 필요하면 직접 구현
//         // 예: testRepository.countByStatus(requestDto.getTestVo().getStatus());

//         // responseDto에 count만 리턴하려면 별도 DTO 만들어도 되고, 아래처럼 처리도 가능
//         // TestResponseDto dto = new TestResponseDto();
//         // dto.setCount(totalCount); // count 필드가 있다면

//         return totalCount;
//     }
// }
