package com.hanghae0705.sbmoney.service;

import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.exception.ApiException;
import com.hanghae0705.sbmoney.exception.ApiRuntimeException;
import com.hanghae0705.sbmoney.model.domain.StatisticsMyDay;
import com.hanghae0705.sbmoney.model.dto.SavedItemForStatisticsDto;
import com.hanghae0705.sbmoney.repository.StatisticsRepository;
import com.hanghae0705.sbmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final UserRepository userRepository;
    private final StatisticsRepository statisticsRepository;

    // 가결별/일별 나의 아낀 내역 저장하기
    public void createMyDailySave(){
        // username, userId 받아오기
        Long userId = getUserId();

        // 날짜 구하기
        LocalDate yesterday = LocalDate.now().minusDays(1); // 2022-07-12
        LocalDateTime startDateTime = yesterday.atTime(LocalTime.MIDNIGHT); // 2022-07-12T00:00
        LocalDateTime endDateTime = yesterday.atTime(LocalTime.MAX); // 2022-07-12T23:59:59.999999999

        // userId로 savedItem 일별 리스트를 높은 가격순으로 구해오기
        List<SavedItemForStatisticsDto> savedItemList = statisticsRepository.findByUserIdAndDate(userId, startDateTime, endDateTime);

        // 받아온 savedItem 의 순서대로 price 랭킹을 매겨 List 에 저장
        List<StatisticsMyDay> statisticsMyDayList = savedItemList.stream()
                .map(savedItem -> StatisticsMyDay.builder()
                        .userId(savedItem.getUserId())
                        .standardDate(yesterday.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                        .itemName(savedItem.getItemName())
                        .totalPrice(savedItem.getTotalPrice())
                        .totalCount(savedItem.getTotalCount())
                        .rankPrice(savedItemList.indexOf(savedItem)+1)
                        .build())
                .collect(Collectors.toList());



        // 받아온 savedItem 을 count 기준으로 정렬하여 List 에 추가
        List<SavedItemForStatisticsDto> savedItemListOrderedByCount = savedItemList.stream().sorted(Comparator.comparing(SavedItemForStatisticsDto::getTotalCount).reversed())
                .collect(Collectors.toList());
        for(SavedItemForStatisticsDto savedItemDto : savedItemListOrderedByCount) {
            for(StatisticsMyDay savedItemStatistics : statisticsMyDayList) {
                if (savedItemDto.getItemName().equals(savedItemStatistics.getItemName())) {
                    savedItemStatistics.changeRankCount(savedItemListOrderedByCount.indexOf(savedItemDto)+1);
                    System.out.println(savedItemStatistics.getRankCount()+" "+savedItemStatistics.getRankPrice()+" "+savedItemStatistics.getItemName());
                }
            }
        }

        // List 를 DB에 추가
        for(StatisticsMyDay savedItemStatistics : statisticsMyDayList) {
            statisticsRepository.saveStatisticsMyDay(savedItemStatistics);
        }
    }

    // 나의 일일 가격순 코드 불러오기
    public Message getMyDailyByUserIdAndPrice(String day){
        Long userId = getUserId();
        //Long userId = 76L;

        List<StatisticsMyDay> result = statisticsRepository.findMyDailyByUserIdAndPrice(userId, day);
        List<StatisticsMyDay.MyDailyByPrice> myDailyByPriceList = result.stream()
                .map(myDaily -> StatisticsMyDay.MyDailyByPrice.builder()
                        .userId(myDaily.getUserId())
                        .rankPrice(myDaily.getRankPrice())
                        .itemName(myDaily.getItemName())
                        .totalPrice(myDaily.getTotalPrice())
                        .build())
                .collect(Collectors.toList());

        return Message.builder()
                .result(true)
                .respMsg("나의 아낀 항목 일일 금액별 통계 조회에 성공했습니다.")
                .data(myDailyByPriceList)
                .build();
    }

    public Message getMyDailyByUserIdAndCount(String day){
        Long userId = getUserId();
        //Long userId = 76L;

        List<StatisticsMyDay> result = statisticsRepository.findMyDailyByUserIdAndCount(userId, day);
        List<StatisticsMyDay.MyDailyByCount> myDailyByCountList = result.stream()
                .map(myDaily -> StatisticsMyDay.MyDailyByCount.builder()
                        .userId(myDaily.getUserId())
                        .rankCount(myDaily.getRankCount())
                        .itemName(myDaily.getItemName())
                        .totalCount(myDaily.getTotalCount())
                        .build())
                .collect(Collectors.toList());

        return Message.builder()
                .result(true)
                .respMsg("나의 아낀 항목 일일 횟수별 통계 조회에 성공했습니다.")
                .data(myDailyByCountList)
                .build();
    }

    public Long getUserId() {
        String username = CommonService.getUsername();
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ApiRuntimeException(ApiException.NOT_EXIST_USER)
        ).getId();
    }
}