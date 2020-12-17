package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private final static String REGISTER_FORM = "/WEB-INF/jsp/account/Register.jsp";
    private final static String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reminder= null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sessionvcode = (String)request.getSession().getAttribute("vCode");
        System.out.println(sessionvcode);

        User user = new User();
        int result = 0;
        user.setUsername(username);
        user.setPassword(password);


        if(sessionvcode != null){
            String inputvcode = request.getParameter("vcode");
            System.out.println("页面提交的验证码：" + inputvcode);

            if(sessionvcode.toLowerCase().equals(inputvcode.toLowerCase())) {
                UserService userService = new UserService();
                result = userService.register(user);
                if (result == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    request.getRequestDispatcher(MAIN).forward(request, response);

                } else {
                    reminder = "该用户名已注册，请重新输入！";
                    request.setAttribute("reminder", reminder);
                    request.getRequestDispatcher(REGISTER_FORM).forward(request, response);
                    System.out.println("2222222222222");
                }
            }
            else{
                reminder = "验证码输入错误";
                request.setAttribute("reminder",reminder);
                request.getRequestDispatcher(REGISTER_FORM).forward(request,response);

            }
        }
        else {
            reminder = "请输入验证码";
            request.setAttribute("reminder",reminder);
            request.getRequestDispatcher(REGISTER_FORM).forward(request,response);

        }
        request.removeAttribute("vCode");
    }
}
