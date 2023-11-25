package com.sopkathon.tmdxo.service;

import com.sopkathon.tmdxo.api.dto.DiaryCreateRequest;
import com.sopkathon.tmdxo.api.dto.DiaryInfoResponse;
import com.sopkathon.tmdxo.api.dto.DiaryInfosResponse;
import com.sopkathon.tmdxo.domain.Diary;
import com.sopkathon.tmdxo.domain.Like;
import com.sopkathon.tmdxo.global.common.exception.NotFoundException;
import com.sopkathon.tmdxo.repository.DiaryRepository;
import com.sopkathon.tmdxo.repository.LikeRepository;
import com.sopkathon.tmdxo.service.vo.TodayDiaryInfoVO;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	public List<TodayDiaryInfoVO> findAllTodayDiaries() {
		List<Diary> diaries = diaryRepository.findByDate(LocalDate.now());
		return diaries.stream()
				.map(TodayDiaryInfoVO::fromEntity)
				.toList();
	}

	public void likeDiary(final Long diaryId) {
		Diary diary = diaryRepository.findById(diaryId)
			.orElseThrow(() -> new NotFoundException(String.format("존재하지 않는 다이어리ID(%d) 입니다.", diaryId)));

		diary.plusLikeCount();
	}

	public void writeDiary(DiaryCreateRequest request) {
		Like like = likeRepository.save(Like.newInstance());
		Diary diary = Diary.builder()
			.title(request.title())
			.content(request.content())
			.author(request.author())
			.email(request.email())
			.date(request.tomorrowDate())
			.emojiType(request.emojiType())
			.like(like)
			.build();

		diaryRepository.save(diary);
	}

	public int countTomorrowDiaries() {
		List<Diary> diaries = diaryRepository.findByDate(LocalDate.now().plusDays(1));
		return diaries.size();
	}
}
