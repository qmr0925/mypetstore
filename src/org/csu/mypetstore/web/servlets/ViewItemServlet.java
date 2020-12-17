package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewItemServlet")
public class ViewItemServlet extends HttpServlet {
    private  static final String VIEW_Item="/WEB-INF/jsp/catalog/Item.jsp";
    private  String itemId;
    private String productId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId=request.getParameter("itemId");

        CatalogService service=new CatalogService();
        Item item=service.getItem(itemId);
        int item1=service.getInventoryQuantity(itemId);

        productId=request.getParameter(productId);
        List<Item> itemList=service.getItemListByProduct(productId);

        HttpSession session=request.getSession();
        session.setAttribute("item",item);
        session.setAttribute("item1",item1);
        session.setAttribute("itemList",itemList);

        request.getRequestDispatcher(VIEW_Item).forward(request,response);

    }
}
