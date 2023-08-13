# fastcampus-project-board

깃 브랜치 운영 방법론

* gitflow : master, develop, feature, release, hotfix 브랜치를 설정하고 운영하는 바익
* github flow : main(master), feature 브랜치만으로 운영하는 방식

브랜치 전략을 세우는 이유/요령

* 하나의 프로젝트 소스코드를 다수가 다루면서 발생하는 부작용 해결
* 개발 협업을 원할하게 하기 위한 약속
* 전략을 세울 때 고려할 수 있는 요소들
    * 이 브랜치는 제품으로 내보낼 수 있는가?
    * 이 브랜치는 빌드 실패를 허용하는가?
    * 이 브랜치는 테스트 실패를 허용하는가?
    * 이 브랜치는 임시로 운영하는가? 유지하지 않고 수시로 삭제하는가?

https://github.com/nvie/gitflow
https://docs.github.com/en/get-started/quickstart/github-flow



## 개발 환경

* Intellij IDEA Ultimate 2022.1.1 ~ 2022.1.3
* Java 17
* Gradle 7.4.1
* Spring Boot 2.7.0

## 기술 세부 스택

Spring Boot

* Spring Boot Actuator
* Spring Web
* Spring Data JPA
* Rest Repositories
* Rest Repositories HAL Explorer
* Thymeleaf
* Spring Security
* H2 Database
* MySQL Driver
* Lombok
* Spring Boot DevTools
* Spring Configuration Processor

그 외

* QueryDSL 5.0.0
* Bootstrap 5.2.0-Beta1
* Heroku

## 데모 페이지

(작성 중)

## 질문, 건의

프로젝트에 관해 궁금하신 점이나 건의 사항이 있으시다면 아래 항목을 이용해 주세요.

* Issues: 버그 리포트, 제안 사항
* Discussions: 프로젝트와 관련한 논의와 정보


## 릴리즈
태깅을 먼저 하고 릴리즈 탭에서 버전을 입력하고 릴리즈 수행



# 고도화

## 예상하는 세부 기능들

* 대댓글 도메인 설계
* 해시태그 기능 개선을 위한 게시글 도메인의 수정 여부 검토
* 관련 비지니스 로직과 테스트 변경
* 인증 기능 업데이트 : OAuth 2.0 + Kakao 로그인
* 웹화면 변경
  * 게시판 페이지: 대댓글 표현
  * 로그인 페이지 : Kakao 로그인 화면으로 변경
* 추가 의존성 조사 및 선택
  * Spring Initializr - OAuth2 Client, Valut Configuration
  * Swagger UI - Springdoc-openapi


# PostgreSQL 설치(MAC에서)

> brew services start postgresql

> psql postgres userid

postgres=#

Select * from pg_user;


userid@localhost ~ % psql board
psql (14.9 (Homebrew))
Type "help" for help.

board=# conninfo
board-# \conninfo
You are connected to database "board" as user "userid" via socket in "/tmp" at port "5432".
board-#


create user boarder with password ‘1234’;

Show list of relations
\d

Show list of roles

board=# \du
List of roles
Role name  |                         Attributes                         | Member of
-------------+------------------------------------------------------------+-----------
userid | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
boarder     | 

