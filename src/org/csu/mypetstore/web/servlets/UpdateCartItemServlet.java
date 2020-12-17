package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatalogService;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UpdateCartItemServlet extends HttpServlet {
    private User user;
    private CartService cartService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = user.getUsername();
        String itemId = request.getParameter("itemId");
        String quantityStr = request.getParameter("quantity");
        int quantity = 0;
        cartService = new CartService();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(quantityStr == "" || quantityStr.equals(null)){
            cartService.removeCartItemByUsernameAndItemId(username, itemId);
            out.write("{\"isRemoved\":\""+true+"{\"itemId\":\"" + itemId + "\"}");
        }
        else {
            quantity = Integer.parseInt(quantityStr);
            System.out.println(itemId+"数量"+quantity);
            if(quantity == 0){
                cartService.removeCartItemByUsernameAndItemId(username, itemId);
                out.write("{\"isRemoved\":\"" + true + "\",\"itemId\":\"" + itemId + "\"}");
            }
            else {
                cartService.updateItemByItemIdAndQuantity(username, itemId, quantity);
                CartItem item = cartService.getCartItemByUsernameAndItemId(username, itemId);
                String html = "<fmt:formatNumber type='number' pattern='$#,##0.00'>$" + item.getTotal() + ".00</fmt:formatNumber>";
                System.out.println("html"+html);
                out.write("{\"isRemoved\":\"" + false + "\",\"itemId\":\"" + itemId + "\",\"quantity\":\"" + quantity +
                        "\",\"totalcost\":\"" + item.getTotal() + "\",\"html\":\"" + html + "\"}");
            }
        }

        List<CartItem> cart = cartService.selectItemByUsername(username);
        session.setAttribute("cart", cart);
        out.flush();
        out.close();
    }
}
