package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.UserFind;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.UserFindDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class UserFindDaoImpl implements UserFindDao {
    private static String deleteUserFindByUsernameAndLoginTimeSQL = "delete from log where username=? and logintime=?";
    private static String insertUserFindByUserNameAndLoginTimeAndUrlSQL = "insert into log(username,logintime,url) " +
            "values(?,?,?)";

    public void deleteByUserNameAndLoginTime(String username, String loginTime){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserFindByUsernameAndLoginTimeSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,loginTime);
            int result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertUserFindByUserNameAndLoginTimeAndUrl(String username, String loginTime, String url){
        int result = 0;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserFindByUserNameAndLoginTimeAndUrlSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,loginTime);
            preparedStatement.setString(3,url);
            result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
