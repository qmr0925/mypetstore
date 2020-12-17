package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private String workingItemId;
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");

        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        if(user == null){
            session.setAttribute("message", "Please sign in first.");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
        else {
            String username = user.getUsername();
            CartService cartService = new CartService();
            CartItem cartItem = cartService.getCartItemByUsernameAndItemId(username, workingItemId);

            if (cartItem == null) {
                session.setAttribute("message", "Attempted to remove all null CartItem from Cart.");
                request.getRequestDispatcher(ERROR).forward(request, response);
            } else {
                cartService.removeCartItemByUsernameAndItemId(username, workingItemId);
                List<CartItem> cart = cartService.selectItemByUsername(username);
                session.setAttribute("cart", cart);
                request.getRequestDispatcher(VIEW_CART).forward(request, response);
            }
        }
    }
}
