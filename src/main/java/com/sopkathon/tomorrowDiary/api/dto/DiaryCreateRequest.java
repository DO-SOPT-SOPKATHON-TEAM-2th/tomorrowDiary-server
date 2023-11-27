package com.sopkathon.tomorrowDiary.api.dto;

import java.time.LocalDate;

import com.sopkathon.tomorrowDiary.domain.EmojiType;

public record DiaryCreateRequest(
	String title,
	String content,
	String author,
	String email,
	LocalDate tomorrowDate,
	EmojiType emojiType
) {
}
