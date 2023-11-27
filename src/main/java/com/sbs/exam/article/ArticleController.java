package com.sbs.exam.article;

import com.sbs.exam.Rq;

public class ArticleController {
  public void showList(Rq rq) {
    rq.appendBody("게시물 리스트 화면");
  }
}
