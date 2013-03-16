package com.github.springrest.base;

import java.io.Serializable;
import java.util.Date;

public class UserContext
  implements Serializable
{
  private static final long serialVersionUID = 4333202957297300445L;
  private String loginName;
  private long loginId;
  private Date lastLoginTime;

  public String getLoginName()
  {
    return this.loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public long getLoginId() {
    return this.loginId;
  }

  public void setLoginId(long loginId) {
    this.loginId = loginId;
  }

  public Date getLastLoginTime() {
    return this.lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }
}