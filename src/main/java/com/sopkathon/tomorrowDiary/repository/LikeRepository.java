package com.sopkathon.tomorrowDiary.repository;

import com.sopkathon.tomorrowDiary.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
