package com.sopkathon.tmdxo.repository;

import com.sopkathon.tmdxo.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
