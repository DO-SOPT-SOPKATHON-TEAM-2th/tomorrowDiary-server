package com.sopkathon.tomorrowDiary.service;

import com.sopkathon.tomorrowDiary.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

}
