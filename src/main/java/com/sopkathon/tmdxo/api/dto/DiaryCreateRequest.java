package com.sopkathon.tmdxo.api.dto;

import java.time.LocalDate;

import com.sopkathon.tmdxo.domain.EmojiType;

public record DiaryCreateRequest(
	String title,
	String content,
	String author,
	String email,
	LocalDate tomorrowDate,
	EmojiType emojiType
) {
}
