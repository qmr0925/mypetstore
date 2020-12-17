package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.UserFind;

import java.sql.Timestamp;

public interface UserFindDao {
    public void deleteByUserNameAndLoginTime(String username,String loginTime);
    public void insertUserFindByUserNameAndLoginTimeAndUrl(String username, String loginTime, String url);
}
