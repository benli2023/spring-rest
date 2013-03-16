package com.github.springrest.base;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper
{
  public static final String SESSION_USER = "SESSION_USER";

  public static UserContext getLoginUser(HttpServletRequest request)
  {
    HttpSession session = request.getSession();
    UserContext userContext = (UserContext)session.getAttribute("SESSION_USER");
    if (userContext == null) {
      userContext = new UserContext();
      userContext.setLastLoginTime(new Date());
      userContext.setLoginId(1L);
      userContext.getLoginName();
    }
    return userContext;
  }
}