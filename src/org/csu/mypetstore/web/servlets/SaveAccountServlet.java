package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveAccountServlet extends HttpServlet {
    private static String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static String MYACCOUNT_FORM = "/WEB-INF/jsp/account/MyAccount.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;

        String password = request.getParameter("password");
        String repeatpwd = request.getParameter("repeatpwd");
        if(!password.equals(repeatpwd)){
            message = "两次输入密码不一致";
            request.setAttribute("message",message);
            request.getRequestDispatcher(MYACCOUNT_FORM).forward(request,response);
            return;
        }

        if(request.getSession().getAttribute("user") == null){
            message = "请先登录！";
            request.setAttribute("message",message);
            request.getRequestDispatcher(MYACCOUNT_FORM).forward(request,response);
            return;
        }

        User user = new User();
        HttpSession session = request.getSession();
        User test = (User)session.getAttribute("user");
        user.setUsername(test.getUsername());
        user.setPassword(request.getParameter("password"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setAddress1(request.getParameter("address1"));
        user.setAddress2(request.getParameter("address2"));
        user.setCity(request.getParameter("city"));
        user.setState(request.getParameter("state"));
        user.setZip(request.getParameter("zip"));
        user.setCountry(request.getParameter("country"));
        user.setLanguagepre(request.getParameter("account.languagePreference"));
        user.setFavoritecata(request.getParameter("account.favoriteCatagoryId"));
        user.setIflist(request.getParameter("account.listOption"));
        user.setIfbanner(request.getParameter("account.bannerOption"));

        UserService userService = new UserService();
        int result = userService.updateUserByUsername(user);
        if(result == 1){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher(MAIN).forward(request,response);
        }
        else{
            message = "申请失败，请重新输入！";
            request.getSession().setAttribute("message",message);
            request.getRequestDispatcher(MYACCOUNT_FORM).forward(request,response);
        }
    }
}
