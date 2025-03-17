package com.fav.fav.common.data;

import java.util.List;

public interface BaseService<RES, REQ> {
    int create(REQ requestDto) throws Exception;

    List<RES> read(REQ requestDto) throws Exception;

    int update(REQ requestDto) throws Exception;

    int delete(REQ requestDto) throws Exception;

    List<RES> readPage(REQ requestDto) throws Exception;

    long count(REQ requestDto) throws Exception;
}
