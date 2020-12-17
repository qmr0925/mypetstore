package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AutoComplete")
public class AutoComplete extends HttpServlet {
    private final static String WordXML = "/WEB-INF/jsp/Auto/wordxml.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word=request.getParameter("word");
        System.out.println("word:"+word);
        request.setAttribute("word",word);
        System.out.println("abcdef");
        request.getRequestDispatcher(WordXML).forward(request,response);
    }
}
