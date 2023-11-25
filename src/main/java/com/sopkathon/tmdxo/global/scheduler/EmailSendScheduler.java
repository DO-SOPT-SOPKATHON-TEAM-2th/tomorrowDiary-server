package com.sopkathon.tmdxo.global.scheduler;

import com.sopkathon.tmdxo.global.email.EmailSender;
import com.sopkathon.tmdxo.service.DiaryService;
import com.sopkathon.tmdxo.service.vo.TodayDiaryInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSendScheduler {
    private final EmailSender emailSender;
    private final DiaryService diaryService;

    @Scheduled(cron = "0 0 22 * * *")
    public void sendTodayEmail() {
        for (TodayDiaryInfoVO todayDiary : diaryService.findAllTodayDiaries()) {
            emailSender.sendEmail(todayDiary.getEmail(), todayDiary.createContent(), todayDiary.createTitle());
        }
    }
}
