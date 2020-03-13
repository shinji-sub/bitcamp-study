package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Prompt;

public class LessonAddServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  LessonService lessonService;

  public LessonAddServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();

    lesson.setTitle(Prompt.getString(in, out, "강의명? "));
    lesson.setDescription(Prompt.getString(in, out, "내용? "));
    lesson.setStartDate(Prompt.getDate(in, out, "강의 시작일? "));
    lesson.setEndDate(Prompt.getDate(in, out, "강의 종료일? "));
    lesson.setTotalHours(Prompt.getInt(in, out, "총 강의 시간? "));
    lesson.setDayHours(Prompt.getInt(in, out, "일 수업 시간? "));
    lessonService.add(lesson);
    out.println("새 게시글을 등록했습니다.");
  }
}
