package org.csu.mypetstore.domain;

import java.math.BigDecimal;

public class CartItem {
    private String username;
    private Item item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;
    private boolean pay;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    private void calculateTotal(){
        if(item != null && item.getListPrice() != null){
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        }
        else{
            total = null;
        }
    }

    public void incrementQuantity() {
        quantity++;
        calculateTotal();
    }

    public void updateQuantity(int quantity){
        this.quantity = quantity;
        calculateTotal();
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
