package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonSearchServlet implements Servlet {

  LessonDao lessonDao;

  public LessonSearchServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    String keyword = Prompt.getString(in, out, "강의명 검색: ");
    if (keyword.length() > 0) {
      params.put("title", keyword);
    }
    Date date = Prompt.getDate(in, out, "강의 시작일 검색: ");
    if (date != null) {
      params.put("startDate", date.toString());
    }
    date = Prompt.getDate(in, out, "강의 종료일 검색: ");
    if (date != null) {
      params.put("endDate", date.toString());
    }

    int value = Prompt.getInt(in, out, "총 강의 시간 검색: ");
    if (value > 0) {
      params.put("totalHours", value);
    }
    value = Prompt.getInt(in, out, "일 강의 시간 검색: ");
    if (value > 0) {
      params.put("dayHours", value);
    }

    out.println("--------------------------------------");
    out.println("[검색 결과]");

    List<Lesson> lessons = lessonDao.findByKeyword(params);
    for (Lesson l : lessons) {
      out.printf("%d, %s, %s ~ %s, %d, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
          l.getEndDate(), l.getTotalHours(), l.getDayHours());
    }
  }
}
