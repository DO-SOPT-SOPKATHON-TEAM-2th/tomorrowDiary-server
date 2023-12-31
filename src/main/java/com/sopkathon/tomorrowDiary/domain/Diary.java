package com.sopkathon.tomorrowDiary.domain;

import com.sopkathon.tomorrowDiary.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "diaries")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Diary extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_id")
	private Long id;

	@Column(name = "diary_title", nullable = false, length = 30)
	private String title;

	@Column(name = "diary_content", nullable = false)
	private String content;

	@Column(name = "diary_author", nullable = false, length = 30)
	private String author;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "diary_date", nullable = false, length = 30)
	private LocalDate date; //내일 일기이기 때문에 일기의 날짜는 내일 날짜로 저장됨

	@Column(name = "emoji_type", nullable = false, length = 30)
	@Enumerated(value = EnumType.STRING)
	private EmojiType emojiType;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "like_id", nullable = false)
	private Like like;


	public int getLikeCount() {
		return like.getCount();
	}

	public void plusLikeCount() {
		like.plusLikeCount();
	}
}
