// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
// 
package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.ArrayList;
import com.eomcs.lms.util.Prompt;


public class LessonHandler {

  ArrayList<Lesson> lessonList;

  Prompt prompt;

  public LessonHandler(Prompt prompt) {
    this.prompt = prompt;
    this.lessonList = new ArrayList<>(); // 안에 내용 생략 가능하다.

  }

  public void listLesson() {
    // LessonList의 보관된 값을 받을 배열을 준비한다.
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }

  public  void addLesson() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? "));
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate((prompt.inputDate("시작일? ")));
    lesson.setEndDate((prompt.inputDate("종료일? ")));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

    this.lessonList.add(lesson);

    System.out.println("저장하였습니다.");
  }

  public void detailLesson() {
    int index = indexOfLesson(prompt.inputInt("번호 ? "));

    if (index == -1) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    Lesson lesson = this.lessonList.get(index);
    System.out.printf("번호: %d\n", lesson.getNo());
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getDescription());
    System.out.printf("시작일: %s\n", lesson.getStartDate());
    System.out.printf("종료일: %s\n", lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }


  public void updateLesson() {

    int index = indexOfLesson(prompt.inputInt("번호 ? "));

    if (index == -1) {
      System.out.println("수업 인덱스가 유효하지 않습니다.");
      return;
    }
    Lesson oldLesson = this.lessonList.get(index);

    Lesson newLesson = new Lesson();

    newLesson.setNo(oldLesson.getNo());

    newLesson.setTitle(prompt.inputString(
        String.format("수업명(%s)? ", oldLesson.getTitle()),
        oldLesson.getTitle()));

    newLesson.setDescription(prompt.inputString(
        String.format("설명(%s)? ", oldLesson.getDescription()),
        oldLesson.getDescription()));

    newLesson.setStartDate(prompt.inputDate(
        String.format("시작일(%s)? ", oldLesson.getStartDate()),
        oldLesson.getStartDate()));

    newLesson.setEndDate(prompt.inputDate(
        String.format("종료일(%s)? ", oldLesson.getEndDate()),
        oldLesson.getEndDate()));

    newLesson.setTotalHours(prompt.inputInt
        (String.format("총수업시간(%s)? ", oldLesson.getTotalHours()),
            oldLesson.getTotalHours()));

    newLesson.setDayHours(prompt.inputInt
        (String.format("일수업시간(%s)? ", oldLesson.getDayHours()),
            oldLesson.getDayHours()));

    if (oldLesson.equals(newLesson)) {
      System.out.println("수업 변경을 취소하였습니다.");
      return;
    }
    this.lessonList.set(index, newLesson);
    System.out.println("수업을 변경했습니다.");
  }

  public void deleteLesson() {
    int index = indexOfLesson(prompt.inputInt("번호 ? "));

    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    this.lessonList.remove(index);

    System.out.println("수업을 삭제했습니다.");
  }
  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }



}
