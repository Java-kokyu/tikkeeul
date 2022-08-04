package com.hanghae0705.sbmoney.controller.statistic;

import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.service.statistic.StatisticsAllUserGoalItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StatisticsAllUserGoalController {

    private final StatisticsAllUserGoalItemService statisticsService;

    // 프론트에서 요청하는 API
    @GetMapping("/api/statistics/goalItem/price")
    public Message getGoalItemByPrice(){
        return statisticsService.getGoalItemByPrice();
    }

    @GetMapping("/api/statistics/goalItem/count")
    public Message getGoalItemByCount(){
        return statisticsService.getGoalItemByCount();
    }

    // 통계 테이블에 저장할 API
    @Scheduled(cron = "0 0 01 * * ?") // 초, 분, 시, 일, 월, 요일 / 매일 5시로 설정되어 있음
    @GetMapping("/api/statistics/goalItem/save")
    public void createGoalSave(){
        statisticsService.createGoalSave();
        log.info(LocalDateTime.now()+" createGoalSave() 실행");
    }
}
