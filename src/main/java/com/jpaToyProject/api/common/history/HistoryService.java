package com.jpaToyProject.api.common.history;

import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    // 이 메소드는 데이터를 실제로 DB에 저장합니다.
    public void saveHistory(HistoryModel historyModel) {
        // DB에 저장하는 로직을 작성합니다.
        // 예를 들어, JPA를 사용하거나, MyBatis로 DB에 기록할 수 있습니다.
        System.out.println("History recorded: " + historyModel);
        // 실제로는 DB에 저장하는 코드가 들어가야 합니다.
    }
}
