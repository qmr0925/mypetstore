package org.csu.mypetstore.domain;

import java.sql.Timestamp;
import java.util.Date;

public class UserFind {
    private String username;
    private String loginTime;
    private String strURL;

    public UserFind(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getStrURL() {
        return strURL;
    }

    public void setStrURL(String strURL) {
        this.strURL = strURL;
    }
}
