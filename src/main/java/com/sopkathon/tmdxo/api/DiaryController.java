package com.sopkathon.tmdxo.api;

import com.sopkathon.tmdxo.api.dto.DiaryCreateRequest;
import com.sopkathon.tmdxo.api.dto.DiaryInfosResponse;
import com.sopkathon.tmdxo.global.common.response.ApiResponse;
import com.sopkathon.tmdxo.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiaryController {
	private final DiaryService diaryService;

	@GetMapping("/diaries")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<DiaryInfosResponse> findAllTomorrowDiaries() {
		return ApiResponse.success(HttpStatus.OK, "내일 일기 전체 조회에 성공하였습니다.", diaryService.findAllTomorrowDiaries());
	}

	@PutMapping("/diary/like/{diaryId}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<Void> likeDiary(@PathVariable final Long diaryId) {
		diaryService.likeDiary(diaryId);
		return ApiResponse.success(HttpStatus.OK, "좋아요 개수가 정상적으로 증가되었습니다.");
	}

	@PostMapping("/diary/write")
	@ResponseStatus(HttpStatus.CREATED)
	public ApiResponse<DiaryCreateRequest> createDiary(@RequestBody DiaryCreateRequest request) {
		diaryService.createDiary(request);
		return ApiResponse.success(HttpStatus.CREATED, "일기 작성에 성공하였습니다.");
	}
}