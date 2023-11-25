# 나는, 내일 Server
내일을 기록하는 일기 웹앱 : 내면 성장을 위해 쓰는 ‘일기’는 과거의 기록이다. 바꿀 수 없는 오늘의 기록 대신, 내일을 상상하며 살아갈 에너지를 느끼자

<br>

## 팀원 소개 👥
<div align="center">

| **최승준** | **김태욱** |
| :------: |  :------: |
| [<img src="https://avatars.githubusercontent.com/u/84304802?v=4" height=150 width=150> <br/> @PgmJun](https://github.com/PgmJun) | [<img src="https://avatars.githubusercontent.com/u/71974850?v=4" height=150 width=150> <br/> @Kim-TaeUk](https://github.com/Kim-TaeUk) |

</div>

<br>

## 기술 스택 ⚒️
- SpringBoot 3.2.0
- Java 17
- MySQL8.0
- Nginx
- AWS

<br>

## 패키지 구조 📁

<img width="536" alt="KakaoTalk_Photo_2023-11-26-03-26-22" src="https://github.com/DO-SOPT-SOPKATHON-TEAM-2th/server/assets/84304802/cd4e2947-07ac-46bf-aff2-89d30c56bc4a">

<br>

## 아키텍쳐 🗺️
![TomorrowDiary](https://github.com/DO-SOPT-CDS-5/EQL-server/assets/84304802/a3c532ec-a9fc-49a1-ac7e-7da3a2902d53)

<br>

## 실행 방법 🏁
#### Local에 현재 Repository Clone
`git clone https://github.com/DO-SOPT-SOPKATHON-TEAM-2th/server.git`

### DB 설정
- Docker Desktop 설치
- Clone한 Repository 폴더에서 터미널 실행
- `docker compose up` 입력

### Build 후 실행
- `./gradlew clean build -x test` 로 빌드
- `cd build/libs`
- `java -jar 빌드파일명.jar` 로 실행

<br>

## 컨벤션 📋

### 💭 Commit
```
# style      코드의 구조/형태 개선
# remove      코드/파일 삭제
# bugfix      버그 수정
# hotfix      긴급 수정
# feat      새 기능
# docs      문서 추가/수정
# init      프로젝트 시작
# test      테스트 추가/수정
# release      릴리즈/버전 태그
# chore      구성 파일 추가/삭제
# refactor      코드 리팩토링
# fix      간단한 수정
```

### 💭 Branch

**`브랜치타입/#이슈번호`** <br>
Ex) `feat/#37`

```
main : 실제 프로덕트 브랜치
develop : 신규 버전 개발 브랜치
feat : 기능 구현 브랜치
fix : 기능 수정 브랜치
refactor : 리팩토링 브랜치
bugfix : 버그 수정 브랜치
```

### 💭 Review
- 리뷰 포인트 있으면 표시 해주기
    - PR에 `to reviews` 탭에 써두기!
- 존댓말로 동글동글한 화법:)
- 모르겠는거 자신 있게 질문하기
