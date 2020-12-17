package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderServlet extends HttpServlet {
    private static final String VIEWORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("order");
        session.setAttribute("lineItems",order.getLineItems());

        OrderService orderService = new OrderService();
        orderService.insertOrder(order);

        // 重置购物车
        CartService cartService = new CartService();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++){
            cartService.updateItemByItemIdAndPay(username, cart.get(i).getItem().getItemId(),true);
        }
        session.removeAttribute("cart");

        request.getRequestDispatcher(VIEWORDER).forward(request,response);
    }
}
