# 32_4 - 클라이언트의 게시물 관리와 관련하여 클라이언트 요청을 처리하기

## 학습목표

- 클라이언트의 요청을 받을 수 있다.
- 클라이언트의 요청에 대해 데이터를 보낼 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/ServerApp.java 변경



## 실습

### 훈련 1: 서비스를 시작할 때 클라이언트의 연결을 기다리는 코드를 추가하라.

- ServerApp.java 변경
  - ServerSocket을 준비한다.
  - 클라이언트 연결을 준비한다.
  
### 훈련 2: 클라이언트의 게시물 목록 요청(/board/list)을 처리하라
-ServerApp.java 변경
  - processRequest() 메서드 변경
- ServerAppTest.java 추가
  - 서버의 응답 기능을 테스트 한다.
- Board.java 변경
  - 통신 테스트 할 때 게시물 필드 정보를 확인할 수 있도록 toString()을 오버라이딩 한다.
  
### 훈련3: 클라이언트의 게시물 등록 요청 (/board/add)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경
  
### 훈련4: 클라이언트의 게시물 조회 요청 (/board/detail)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경

### 훈련5: 클라이언트의 게시물 변경 요청 (/board/update)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경
  
### 훈련6: 클라이언트의 게시물 삭제 요청 (/board/update)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경
  
### 훈련7: 클라이언트의 수업 관리 요청 (/lesson/*)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경
  
  
### 훈련8: 클라이언트의 맴버 관리 요청 (/Member/*)을 처리하라
- ServerApp.java변경
  - processRequest() 메서드 변경
  
