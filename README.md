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
