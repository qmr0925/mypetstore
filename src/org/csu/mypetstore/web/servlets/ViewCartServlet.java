package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String SINGIN_FORM = "/WEB-INF/jsp/account/Signin.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartService cartService = new CartService();
        User user = (User) session.getAttribute("user");
        if(user != null) {

            String username = user.getUsername();
            List<CartItem> cart = cartService.selectItemByUsername(username);

            if (cart == null) {
                cart = new ArrayList<CartItem>();

            }
            session.setAttribute("cart", cart);
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
        else{
            request.getRequestDispatcher(SINGIN_FORM).forward(request, response);
        }
    }

}
