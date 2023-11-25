package com.sopkathon.tmdxo.api.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DiaryInfosResponse {
    private final List<DiaryInfoResponse> diaryInfos;
}
