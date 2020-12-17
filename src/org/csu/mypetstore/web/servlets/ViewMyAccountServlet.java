package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewMyAccountServlet")
public class ViewMyAccountServlet extends HttpServlet {
    private final static String MYACCOUNT_FORM = "/WEB-INF/jsp/account/MyAccount.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(MYACCOUNT_FORM).forward(request,response);
    }
}
