package com.sopkathon.tomorrowDiary.repository;

import com.sopkathon.tomorrowDiary.domain.Diary;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByDate(LocalDate date);
}
