package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.CartDao;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.service.CatalogService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private final static String insertItemByUsernameAndItemIdSQL = "insert into cart(username,itemid,instock,quantity,totalcost,pay) " +
            "values(?,?,?,?,?,false)";
    private final static String updateItemByUsernameAndItemIdSQL = "update cart set quantity = ?,totalcost = ? where username = ? and itemid = ?";
    private final static String selectItemByUsernameAndItemIdSQL = "select * from cart where username = ? and itemid = ?";
    private final static String selectItemByUsernameSQL = "select * from cart where username = ?";
    private final static String removeItemByUsernameAndItemIdSQL = "delete from cart where username = ? and itemid = ?";
    private final static String updateItemByItemIdAndPaySQL = "update cart set pay = ? where username = ? and itemId = ?";

    public int updateItemByUsernameAndItemId(String username, String itemId, int quantity, BigDecimal totalCost){
        int result = 0;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateItemByUsernameAndItemIdSQL);
            preparedStatement.setInt(1,quantity);
            preparedStatement.setBigDecimal(2,totalCost);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,itemId);
            result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public CartItem selectItemByUsernameAndItemId(String username, String itemId){
        CartItem result = null;
        boolean isInStock;
        int quantity = 0;
        BigDecimal totalCost;
        boolean pay = false;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectItemByUsernameAndItemIdSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CatalogService catalogService = new CatalogService();
                result = new CartItem();
                isInStock = resultSet.getBoolean(3);
                quantity = resultSet.getInt(4);
                totalCost = resultSet.getBigDecimal(5);
                pay = resultSet.getBoolean(6);
                result.setItem(catalogService.getItem(itemId));
                result.setInStock(isInStock);
                result.setQuantity(quantity);
                result.setTotal(totalCost);
                result.setPay(pay);
            }
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    public int insertItemByUsernameAndItemId(String username, String itemid, boolean instock, int quantity, BigDecimal totalcost){
        int result = 0;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertItemByUsernameAndItemIdSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,itemid);
            preparedStatement.setBoolean(3,instock);
            preparedStatement.setInt(4,quantity);
            preparedStatement.setBigDecimal(5,totalcost);
            result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<CartItem> selectItemByUsername(String username){
        List<CartItem> cartList = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectItemByUsernameSQL);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            cartList = new ArrayList<CartItem>();
            while (resultSet.next()) {
                CatalogService catalogService = new CatalogService();
                CartItem result = new CartItem();
                String itemId = resultSet.getString(2);
                boolean isInStock = resultSet.getBoolean(3);
                int quantity = resultSet.getInt(4);
                BigDecimal totalCost = resultSet.getBigDecimal(5);
                boolean pay = resultSet.getBoolean(6);
                if(!pay) {
                    result.setItem(catalogService.getItem(itemId));
                    result.setInStock(isInStock);
                    result.setQuantity(quantity);
                    result.setTotal(totalCost);
                    cartList.add(result);
                }
            }
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cartList;
    }

    public void removeItemByUsernameAndItemId(String username, String itemId){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(removeItemByUsernameAndItemIdSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,itemId);
            int result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateItemByItemIdAndPay(String username, String itemId, boolean pay){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateItemByItemIdAndPaySQL);
            preparedStatement.setBoolean(1,pay);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,itemId);
            int result = preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
