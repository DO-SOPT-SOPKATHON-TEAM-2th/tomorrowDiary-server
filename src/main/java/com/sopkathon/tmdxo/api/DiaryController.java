package com.sopkathon.tmdxo.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sopkathon.tmdxo.api.dto.DiaryCreateRequest;
import com.sopkathon.tmdxo.api.dto.DiaryInfosResponse;
import com.sopkathon.tmdxo.global.common.response.ApiResponse;
import com.sopkathon.tmdxo.service.DiaryService;

import lombok.RequiredArgsConstructor;

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

	@PostMapping("/diary/write")
	@ResponseStatus(HttpStatus.CREATED)
	public ApiResponse<DiaryCreateRequest> createDiary(@RequestBody DiaryCreateRequest request) {
		diaryService.createDiary(request);
		return ApiResponse.success(HttpStatus.CREATED, "일기 작성에 성공하였습니다.");
	}
}
