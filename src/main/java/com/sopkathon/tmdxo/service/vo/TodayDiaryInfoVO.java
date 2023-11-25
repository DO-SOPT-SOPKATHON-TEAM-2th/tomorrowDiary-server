package com.sopkathon.tmdxo.service.vo;

import com.sopkathon.tmdxo.domain.Diary;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TodayDiaryInfoVO {
    private final String author;
    private final String email;
    private final String content;

    public static TodayDiaryInfoVO fromEntity(Diary diary) {
        return builder()
                .author(diary.getAuthor())
                .email(diary.getEmail())
                .content(diary.getContent())
                .build();
    }

    public String createTitle() {
        return String.format("%s 님, 당신의 오늘은 어떠셨나요?", author);
    }

    public String createContent() {
        return String.format("%s 님이 어제 쓴 오늘의 일기에요.\n%s", author, content);
    }
}
