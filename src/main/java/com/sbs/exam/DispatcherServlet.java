package com.sbs.exam;

import com.sbs.exam.article.ArticleController;
import com.sbs.exam.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    ArticleController articleController = new ArticleController();
    MemberController memberController = new MemberController();

    // getRequestURI는
    // http://localhost:8081/usr/article/list/free?page=1 에서
    // /usr/article/list/free 부분만 가져온다.
    String url = req.getRequestURI();

    switch (url) {
      case "/usr/article/list" -> articleController.showList(rq);
      case "/usr/member/login" -> memberController.showLogin(rq);
    }
  }
}
