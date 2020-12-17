package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsernameIsExistServlet extends HttpServlet {
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        userService = new UserService();
        User user = userService.findUserByUsername(username);
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        if(user != null){
            out.print("Exist");
        }
        else {
            out.print("Not Exist");
        }

        out.flush();
        out.close();
    }
}
