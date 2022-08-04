package com.hanghae0705.sbmoney.controller.statistic;

import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.service.statistic.StatisticsMyDayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StatisticsMyDayController {

    private final StatisticsMyDayService statisticsMyDayService;

    // 프론트에서 요청하는 API
    @GetMapping("/api/statistics/mysave/day/{day}/price")
    public Message getMyDailySaveByPrice(@PathVariable String day){
        return statisticsMyDayService.getMyDailyByUserIdAndPrice(day);
    }

    @GetMapping("/api/statistics/mysave/day/{day}/count")
    public Message getMyDailySaveByCount(@PathVariable String day){
        return statisticsMyDayService.getMyDailyByUserIdAndCount(day);
    }

    // 통계 테이블에 저장할 API
    @Scheduled(cron = "0 0 01 * * *") // 초, 분, 시, 일, 월, 요일 / 매일 5시로 설정되어 있음
    @GetMapping("/api/statistics/mysave/day/save")
    public void createMyDailySave(){
        statisticsMyDayService.createMyDailySave();
        log.info(LocalDateTime.now()+" createMyDailySave() 실행");
    }
}
