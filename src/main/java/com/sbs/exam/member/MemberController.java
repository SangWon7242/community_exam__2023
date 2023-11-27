package com.sbs.exam.member;

import com.sbs.exam.Rq;

public class MemberController {
  public void showLogin(Rq rq) {
    rq.appendBody("로그인화면");
  }
}
