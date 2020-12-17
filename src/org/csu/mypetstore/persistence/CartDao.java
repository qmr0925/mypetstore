package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.CartItem;

import java.math.BigDecimal;
import java.util.List;

public interface CartDao {
    public int updateItemByUsernameAndItemId(String username, String itemId, int quantity, BigDecimal totalCost);
    public CartItem selectItemByUsernameAndItemId(String username, String itemid);
    public int insertItemByUsernameAndItemId(String username, String itemid, boolean instock, int quantity, BigDecimal totalcost);
    public List<CartItem> selectItemByUsername(String username);
    public void removeItemByUsernameAndItemId(String username, String itemId);
    public void updateItemByItemIdAndPay(String username, String itemId, boolean pay);
}
