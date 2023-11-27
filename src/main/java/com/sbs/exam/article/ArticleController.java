package com.sbs.exam.article;

import com.sbs.exam.Rq;
import com.sbs.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
  public void showList(Rq rq) {
    List<ArticleDto> articleDtos = new ArrayList<>();

    for(int i = 1; i <= 5; i++) {
      articleDtos.add(new ArticleDto(i, "제목" + i, "내용"  + i));
    }

    rq.setAttr("articles", articleDtos);
    rq.view("usr/article/list");
  }
}
