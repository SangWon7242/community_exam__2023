package com.sbs.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;

    try {
      req.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=utf-8");
  }

  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public void appendBody(String str) {
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void setAttr(String name, Object value) {
    req.setAttribute(name, value);
  }

  public void view(String path) {
    // Model2 방식 적용
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");
    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}