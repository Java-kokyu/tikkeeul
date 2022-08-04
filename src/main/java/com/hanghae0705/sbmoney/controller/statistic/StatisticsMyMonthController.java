package com.hanghae0705.sbmoney.controller.statistic;


import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.service.statistic.StatisticsMyMonthlyService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/statistics/mysave")
@RequiredArgsConstructor
public class StatisticsMyMonthController {

    private final StatisticsMyMonthlyService myMonthlyService;

    @GetMapping("/month/{month}/price")
    public Message getMyMonthlyStatisticsByPriceAsc(@PathVariable String month) {
        return myMonthlyService.getMyDailyByUserIdAndPrice(month);
    }

    @GetMapping("/month/{month}/count")
    public Message getMyMonthlyStatisticsByCntAsc(@PathVariable String month) {
        return myMonthlyService.getMyDailyByUserIdAndCount(month);
    }

    @Scheduled(cron = "0 0 01 1 * *")
    @GetMapping("/month/price")
    public void updateMyMonthlyStatistics(){
        myMonthlyService.updateMyMonthlyStatistics();
    }
    // 매달 통계는 매달 1일에 01시에 집계한다.
}
