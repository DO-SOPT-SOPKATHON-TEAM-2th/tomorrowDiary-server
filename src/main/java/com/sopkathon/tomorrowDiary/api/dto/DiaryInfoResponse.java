package com.sopkathon.tomorrowDiary.api.dto;

import com.sopkathon.tomorrowDiary.domain.Diary;
import com.sopkathon.tomorrowDiary.domain.EmojiType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryInfoResponse {
    private final long diaryId;
    private final String title;
    private final String author;
    private final String content;
    private final EmojiType emojiType;
    private final int likeCount;

    public static DiaryInfoResponse fromEntity(final Diary diary) {
        return builder()
                .diaryId(diary.getId())
                .title(diary.getTitle())
                .author(diary.getAuthor())
                .content(diary.getContent())
                .emojiType(diary.getEmojiType())
                .likeCount(diary.getLikeCount())
                .build();
    }
}
