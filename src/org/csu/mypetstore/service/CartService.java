package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.CartDao;
import org.csu.mypetstore.persistence.impl.CartDaoImpl;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class CartService {
    private CartDao cartDao;

    public CartService(){
        cartDao = new CartDaoImpl();
    }

    public void addItemByUsernameAndItemId(String username, Item item,boolean isInStock){
        CartItem cartItem = new CartItem();
        cartItem.setUsername(username);
        cartItem.setItem(item);
        cartItem.setQuantity(0);
        cartItem.setInStock(isInStock);
        cartItem.incrementQuantity();
        int result = cartDao.insertItemByUsernameAndItemId(username,item.getItemId(),cartItem.isInStock(),cartItem.getQuantity(),cartItem.getTotal());
    }

    public void incrementItemByUsernameAndItemId(String username,String itemId){
        CartItem result = cartDao.selectItemByUsernameAndItemId(username,itemId);
        result.incrementQuantity();
        cartDao.updateItemByUsernameAndItemId(username,itemId, result.getQuantity(), result.getTotal());
    }

    public CartItem getCartItemByUsernameAndItemId(String username, String itemId){
        return cartDao.selectItemByUsernameAndItemId(username,itemId);
    }

    public void removeCartItemByUsernameAndItemId(String username, String itemId){
        cartDao.removeItemByUsernameAndItemId(username,itemId);
    }

    public void updateItemByItemIdAndQuantity(String username, String itemId, int quantity){
        CartItem result = cartDao.selectItemByUsernameAndItemId(username,itemId);
        if(result != null) {
            result.updateQuantity(quantity);
            cartDao.updateItemByUsernameAndItemId(username, itemId, result.getQuantity(), result.getTotal());
        }
    }

    public List<CartItem> selectItemByUsername(String username){
        return cartDao.selectItemByUsername(username);
    }

    public BigDecimal getSubTotal(List<CartItem> cartItemList){
        BigDecimal subTotal = new BigDecimal("0");
        Iterator<CartItem> items = cartItemList.iterator();
        while(items.hasNext()){
            CartItem cartItem = (CartItem) items.next();
            Item item = cartItem.getItem();
            BigDecimal listPrice = item.getListPrice();
            BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
            subTotal = subTotal.add(listPrice.multiply(quantity));
        }
        return subTotal;
    }

    public void updateItemByItemIdAndPay(String username, String itemId, boolean pay){
        cartDao.updateItemByItemIdAndPay(username,itemId,pay);
    }
}
