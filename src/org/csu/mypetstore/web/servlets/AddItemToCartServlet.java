package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddItemToCartServlet extends HttpServlet {

    //1.处理完请求后的跳转页面
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    //2.定义处理该请求所需的数据
    private String workingItemId;
    private User user;

    //3.是否需要调用业务逻辑层
    private CatalogService catalogService;
    private CartService cartService;

    private static final String CAECK_OUT = "/WEB-INF/jsp/Checkout.jsp";
    private static final String SIGNIN_FORM = "/WEB-INF/jsp/account/Signin.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher(SIGNIN_FORM).forward(request, response);
        }
        else {
            String username = user.getUsername();
            cartService = new CartService();
            CartItem cartItem = cartService.getCartItemByUsernameAndItemId(username, workingItemId);

            if (cartItem != null) {
                if(!cartItem.isPay()) {
                    cartService.incrementItemByUsernameAndItemId(username, workingItemId);
                }
                else {
                    cartService.updateItemByItemIdAndPay(username, workingItemId, false);
                    cartService.updateItemByItemIdAndQuantity(username, workingItemId, 1);
                    System.out.println("success!");
                }
            } else {
                catalogService = new CatalogService();
                boolean isInStock = catalogService.isItemInStock(workingItemId);
                Item item = catalogService.getItem(workingItemId);
                cartService.addItemByUsernameAndItemId(username, item, isInStock);
            }
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<CartItem>();
            }
            cart = cartService.selectItemByUsername(username);
            session.setAttribute("cart", cart);
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }
}
