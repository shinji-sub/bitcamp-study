package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.proxy.BoardDaoProxy;
import com.eomcs.lms.util.Prompt;

// "/board/detail" 명령 처리
public class BoardDetailCommand implements Command {

  Prompt prompt;
  BoardDaoProxy boardDao;

  public BoardDetailCommand(BoardDaoProxy boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }


  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Board board = boardDao.findByNo(no);
      System.out.printf("번호: %d\n", board.getNo());
      System.out.printf("제목: %s\n", board.getTitle());
      System.out.printf("등록일: %s\n", board.getDate());
      System.out.printf("조회소: %d\n", board.getViewCount());
    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}
