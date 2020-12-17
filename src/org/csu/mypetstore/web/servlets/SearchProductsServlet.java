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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchProductsServlet")
public class SearchProductsServlet extends HttpServlet {

    private static final String VIEW_Search="/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private  String keyword;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyword=request.getParameter("keyword");
        Product product=new Product();
        Item item=new Item();
        CatalogService service=new CatalogService();
        List<Product> productList=new ArrayList<Product>();
        productList=service.searchProductList(keyword);
        List<Item> itemList=new ArrayList<>();

        HttpSession session=request.getSession();

        session.setAttribute("productList",productList);
        request.getRequestDispatcher(VIEW_Search).forward(request,response);
    }
}
