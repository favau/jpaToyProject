package com.fav.fav.common.history;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoryModel {
    private String callUrl;
    private String requestData;
    private String responseData;
    private int processTime;
    private String resultMessage;
    private boolean result;
    private int errorCode;
}
