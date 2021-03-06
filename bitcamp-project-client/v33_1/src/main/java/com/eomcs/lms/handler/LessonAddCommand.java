// "/lesson/add" 커멘드 실행
package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.proxy.LessonDaoProxy;
import com.eomcs.lms.util.Prompt;

public class LessonAddCommand implements Command {

  LessonDaoProxy lessonDao;
  Prompt prompt;

  public LessonAddCommand(LessonDaoProxy lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? "));
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate((prompt.inputDate("시작일? ")));
    lesson.setEndDate((prompt.inputDate("종료일? ")));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

    try {
      lessonDao.insert(lesson);


      System.out.println("저장하였습니다.");
    } catch (Exception e) {

      System.out.println("저장 실패!");
    }
  }
}
