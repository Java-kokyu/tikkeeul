package com.hanghae0705.sbmoney.controller.statistic;

import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.service.statistic.StatisticsAllUserDayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class StatisticsAllUserDayController {

    private final StatisticsAllUserDayService statisticsAllUserDayService;
    // 프론트에서 요청하는 API
    @GetMapping("/api/statistics/allUser/day/{day}/price")
    public Message getMyDailySaveByPrice(@PathVariable String day){
        return statisticsAllUserDayService.getAllUserDailyByPrice(day);
    }

    @GetMapping("/api/statistics/allUser/day/{day}/count")
    public Message getMyDailySaveByCount(@PathVariable String day){
        return statisticsAllUserDayService.getAllUserDailyByCount(day);
    }

    // 통계 테이블에 저장할 API
    @Scheduled(cron = "0 0 01 * * *") // 초, 분, 시, 일, 월, 요일 / 매일 5시로 설정되어 있음
    @GetMapping("/api/statistics/allUser/day/price")
    public void createAllUserMonthlySave(){
        statisticsAllUserDayService.createAllUserDailySave();
        log.info("createAllUserDailySave() 실행");
    }
}