package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.proxy.MemberDaoProxy;
import com.eomcs.lms.util.Prompt;

// "/member/detail 커멘드 실행
public class MemberDetailCommand implements Command {

  MemberDaoProxy memberDao;
  Prompt prompt;

  public MemberDetailCommand(MemberDaoProxy memberDao, Prompt prompt) {
    this.memberDao = memberDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호 ?");

      Member member = memberDao.findByNo(no);
      System.out.printf("번호: %s\n", member.getNo());
      System.out.printf("이름: %s\n", member.getName());
      System.out.printf("이메일: %s\n", member.getEmail());
      System.out.printf("암호: %s\n", member.getPassword());
      System.out.printf("사진: %s\n", member.getPhoto());
      System.out.printf("전화: %s\n", member.getTel());
    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}