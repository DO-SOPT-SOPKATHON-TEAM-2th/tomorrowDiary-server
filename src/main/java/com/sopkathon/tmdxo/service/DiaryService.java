package com.sopkathon.tmdxo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sopkathon.tmdxo.api.dto.DiaryCreateRequest;
import com.sopkathon.tmdxo.api.dto.DiaryInfoResponse;
import com.sopkathon.tmdxo.api.dto.DiaryInfosResponse;
import com.sopkathon.tmdxo.domain.Diary;
import com.sopkathon.tmdxo.domain.Like;
import com.sopkathon.tmdxo.repository.DiaryRepository;
import com.sopkathon.tmdxo.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {
	private final DiaryRepository diaryRepository;
	private final LikeRepository likeRepository;

	@Transactional(readOnly = true)
	public DiaryInfosResponse findAllTomorrowDiaries() {
		List<Diary> diaries = diaryRepository.findByDate(LocalDate.now().plusDays(1));
		List<DiaryInfoResponse> diaryInfos = diaries.stream()
			.map(DiaryInfoResponse::fromEntity)
			.toList();

		return new DiaryInfosResponse(diaryInfos);
	}

	@Transactional
	public void createDiary(DiaryCreateRequest request) {
		Like like = likeRepository.save(Like.newInstance());
		Diary diary = Diary.builder()
			.title(request.title())
			.content(request.content())
			.author(request.author())
			.email(request.email())
			.date(request.tomorrowDate().plusDays(1))
			.emojiType(request.emojiType())
			.like(like)
			.build();

		diaryRepository.save(diary);
	}
}
