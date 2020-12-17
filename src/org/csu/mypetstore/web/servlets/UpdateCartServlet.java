package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = user.getUsername();

        CartService cartService = new CartService();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String itemId = paramNames.nextElement();
            String quantityString = request.getParameter(itemId);
            int quantity = 0;
            if(quantityString == "" || quantityString.equals(null)){
                cartService.removeCartItemByUsernameAndItemId(username, itemId);
            }
            else {
                quantity = Integer.parseInt(quantityString);
                if(quantity == 0){
                    cartService.removeCartItemByUsernameAndItemId(username, itemId);
                }
                else {
                    cartService.updateItemByItemIdAndQuantity(username, itemId, quantity);
                }
            }
        }

        List<CartItem> cart = cartService.selectItemByUsername(username);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(VIEW_CART).forward(request, response);
    }
}
