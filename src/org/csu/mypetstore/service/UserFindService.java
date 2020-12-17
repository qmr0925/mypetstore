package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.persistence.UserFindDao;
import org.csu.mypetstore.persistence.impl.UserFindDaoImpl;

import java.sql.Timestamp;

public class UserFindService {
    private UserFindDao userFindDao;

    public UserFindService(){
        userFindDao = new UserFindDaoImpl();
    }

    public void deleteByUserNameAndLoginTime(String username, String loginTime){
        userFindDao.deleteByUserNameAndLoginTime(username, loginTime);
    }

    public void insertUserFindByUserNameAndLoginTimeAndUrl(String username, String loginTime, String url){
        userFindDao.insertUserFindByUserNameAndLoginTimeAndUrl(username, loginTime, url);
    }
}
