# 32_6 - 커맨드 패턴을 적용하여 요청 처리 메서드를 객체화 하기

## 학습목표

- 커맨드 패턴의 동작 원리를 이해한다.
- 커맨드 패턴을 코드에 적용할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/servlet 패키지 생성
- src/main/java/com/eomcs/lms/servlet/Servlet.java 추가
- src/main/java/com/eomcs/lms/servlet/BoardListServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/BoardAddServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/BoardDetailServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/BoardUpdateServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/BoardDeleteServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/LessonListServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/LessonAddServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/LessonDetailServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/LessonUpdateServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/LessonDeleteServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/MemberListServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/MemberAddServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/MemberDetailServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/MemberUpdateServlet.java 추가
- src/main/java/com/eomcs/lms/servlet/MemberDeleteServlet.java 추가
- src/main/java/com/eomcs/lms/ServerApp.java 변경

## 실습

### 훈련 1: 커맨드 패턴의 인터페이스 정의.

- com.eomcs.servlet 패키지 생성한다.
- com.eomcs.servlet.Servlet 인터페이스를 정의한다.

### 훈련 2: 각각의 요청 처리 메서드를 인터페이스 규칙에 따라 클래스로 정의하라

- listBoard()를 BoardListServlet 클래스로 정의한다.
- addBoard()를 BoardAddServlet 클래스로 정의한다.
- detailBoard()를 BoardDetailServlet 클래스로 정의한다.
- updateBoard()를 BoardUpdateServlet 클래스로 정의한다.
- deleteBoard()를 BoardDeleteServlet 클래스로 정의한다.

- listMember() : MemberListServlet 클래스로 정의한다.
- addMember() : MemberAddServlet 클래스로 정의한다.
- detailMember() : MemberDetailtServlet 클래스로 정의한다.
- updateMember() : MemberUpdateServlet 클래스로 정의한다.
- deleteMember() : MemberDeleteServlet 클래스로 정의한다.
 
- listLesson() : LessonListServlet 클래스로 정의한다.
- addLesson() : LessonAddServlet 클래스로 정의한다.
- detailLesson() : LessonDetailServlet 클래스로 정의한다.
- updateLesson() : LessonUpdateServlet 클래스로 정의한다.
- deleteLesson() : LessonDeleteServlet 클래스로 정의한다.