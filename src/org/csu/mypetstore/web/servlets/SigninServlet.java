package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninServlet extends HttpServlet {
    private final static String SIGNIN_FORM = "/WEB-INF/jsp/account/Signin.jsp";
    private final static String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = null;
        String authCode = (String)request.getSession().getAttribute("authCode");
        String inputCode  =request.getParameter("authCode");
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        UserService userService = new UserService();
        User logonResult = userService.signin(user);
        if(logonResult == null || !authCode.equals(inputCode)){
            msg = "用户名或密码不正确";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher(SIGNIN_FORM).forward(request,response);
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("user",logonResult);
            request.setAttribute("user",logonResult);
            request.getRequestDispatcher(MAIN).forward(request,response);
        }
    }
}
