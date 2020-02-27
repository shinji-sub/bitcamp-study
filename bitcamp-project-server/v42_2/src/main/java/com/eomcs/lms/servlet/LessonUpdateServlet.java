package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Lesson old = lessonDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Lesson lesson = new Lesson();
    lesson.setNo(no);

    lesson.setTitle(Prompt.getString(in, out, "수업명(%s)? \n", old.getTitle()));

    lesson.setDescription(Prompt.getString(in, out, "설명:(%s)? \n", old.getDescription()));

    lesson.setStartDate(Prompt.getDate( //
        in, //
        out, //
        "강의 시작일(%s)? \n", old.getStartDate().toString()));

    lesson.setEndDate(Prompt.getDate(//
        in, //
        out, //
        "강의 종료일(%s)? \n", old.getEndDate().toString()));

    lesson.setTotalHours(Prompt.getInt(//
        in, //
        out, //
        "총 강의 시간(%d)? \n", String.valueOf(old.getTotalHours())));

    lesson.setDayHours(Prompt.getInt( //
        in, //
        out, //
        "총 수업 시간(%d)? \n", String.valueOf(old.getDayHours())));


    if (lessonDao.update(lesson) > 0) {
      out.println("강의를 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
