package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserImpl implements UserDAO {

    private final static String findUserByUsernameSQL = "select * from user where username = ?";
    private final static String findUserByUsernameAndPasswordSQL = "select * from user where username = ? and password = ?";
    private final static String updateUserByUsernameSQL =
            "update user set password=?,firstname=?,lastname=?,email=?,phone=?,address1=?,address2=?,city=?,state=?,zip=?,country=?," +
                    "languagepre=?,favoritecata=?,iflist=?,ifbanner=?" +
                    " where username = ?";
    private static String insertUserByUsernameAndPasswordSQL =
            "insert into user (username,password) values (?,?)";

    @Override
    public User findUserByUsername(String username) {
        User result = null;

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findUserByUsernameSQL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new User();
                result.setId(resultSet.getString(1));
                result.setUsername(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setFirstname(resultSet.getString(4));
                result.setLastname(resultSet.getString(5));
                result.setEmail(resultSet.getString(6));
                result.setPhone(resultSet.getString(7));
                result.setAddress1(resultSet.getString(8));
                result.setAddress2(resultSet.getString(9));
                result.setCity(resultSet.getString(10));
                result.setState(resultSet.getString(11));
                result.setZip(resultSet.getString(12));
                result.setCountry(resultSet.getString(13));
                result.setLanguagepre(resultSet.getString(14));
                result.setFavoritecata(resultSet.getString(15));
                result.setIflist(resultSet.getString(16));
                result.setIfbanner(resultSet.getString(17));
            }
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findUserByUsernameAndPassword(User user) {
        User result = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findUserByUsernameAndPasswordSQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new User();
                result.setId(resultSet.getString(1));
                result.setUsername(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setFirstname(resultSet.getString(4));
                result.setLastname(resultSet.getString(5));
                result.setEmail(resultSet.getString(6));
                result.setPhone(resultSet.getString(7));
                result.setAddress1(resultSet.getString(8));
                result.setAddress2(resultSet.getString(9));
                result.setCity(resultSet.getString(10));
                result.setState(resultSet.getString(11));
                result.setZip(resultSet.getString(12));
                result.setCountry(resultSet.getString(13));
                result.setLanguagepre(resultSet.getString(14));
                result.setFavoritecata(resultSet.getString(15));
                result.setIflist(resultSet.getString(16));
                result.setIfbanner(resultSet.getString(17));
            }
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateUserByUsername(User user) {
        int result = 0;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement2 = connection.prepareStatement(updateUserByUsernameSQL);
            preparedStatement2.setString(1, user.getPassword());
            preparedStatement2.setString(2, user.getFirstname());
            preparedStatement2.setString(3, user.getLastname());
            preparedStatement2.setString(4, user.getEmail());
            preparedStatement2.setString(5, user.getPhone());
            preparedStatement2.setString(6, user.getAddress1());
            preparedStatement2.setString(7, user.getAddress2());
            preparedStatement2.setString(8, user.getCity());
            preparedStatement2.setString(9, user.getState());
            preparedStatement2.setString(10, user.getZip());
            preparedStatement2.setString(11, user.getCountry());
            preparedStatement2.setString(12, user.getLanguagepre());
            preparedStatement2.setString(13, user.getFavoritecata());
            preparedStatement2.setString(14, user.getIflist());
            preparedStatement2.setString(15, user.getIfbanner());
            preparedStatement2.setString(16, user.getUsername());
            int resultSet2 = preparedStatement2.executeUpdate();
            if (resultSet2 == 1) {
                result = 1;
            }
            DBUtil.closePreparedStatement(preparedStatement2);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insertUserByUsernameAndPassword(User user) {
        int result =0;
        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement2 = connection.prepareStatement(findUserByUsernameAndPasswordSQL);
            preparedStatement2.setString(1,user.getUsername());
            preparedStatement2.setString(2,user.getPassword());
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            System.out.println(user.getUsername());
            System.out.println("aaaaaaaaaaaaaa");
            while (resultSet2.next()){
                return result;

            }
            System.out.println("bbbbbbbbbbbbbbb");
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertUserByUsernameAndPasswordSQL);
            preparedStatement1.setString(1,user.getUsername());
            preparedStatement1.setString(2,user.getPassword());
            result = preparedStatement1.executeUpdate();

            System.out.println("result:"+result);

            DBUtil.closePreparedStatement(preparedStatement1);
            DBUtil.closePreparedStatement(preparedStatement2);
            DBUtil.closeConnection(connection);



        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
}
}
