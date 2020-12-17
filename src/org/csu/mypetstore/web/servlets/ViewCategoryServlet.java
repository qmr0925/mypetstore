package org.csu.mypetstore.web.servlets;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewCategoryServlet extends HttpServlet {
    private static  final String VIEW_CATEGORY="/WEB-INF/jsp/catalog/Category.jsp";
    private String categoryId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      categoryId=request.getParameter("categoryId");
        CatalogService service=new CatalogService();
        Category category=service.getCategory(categoryId);
        List<Product> productList=new ArrayList<Product>();
        productList=service.getProductListByCategory(categoryId);
       //System.out.print(productList[0].getName());
//存储信息
        HttpSession session=request.getSession();
        session.setAttribute("category",category);
        session.setAttribute("productList",productList);
        request.getRequestDispatcher(VIEW_CATEGORY).forward(request,response);
    }
}
