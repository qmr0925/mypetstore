package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ConfirmOrderServlet extends HttpServlet {
    private static final String CONFIRMORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private User account;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cardType = request.getParameter("cardType");
        String creditCard = request.getParameter("creditCard");
        String expiryDate = request.getParameter("expiryDate");
        account = (User)session.getAttribute("user");
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String address1 = request.getParameter("address1");
//        String address2 = request.getParameter("address2");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String zip = request.getParameter("zip");
//        String country = request.getParameter("country");
//        System.out.println(firstName);
//        System.out.println(state);



        // 修改订单消息
        Order order = (Order)session.getAttribute("order");
        order.setCardType(cardType);
        order.setCreditCard(creditCard);
        order.setExpiryDate(expiryDate);
//        order.setBillToFirstName(firstName);
//        order.setBillToLastName(lastName);
        order.setShipToFirstName(account.getFirstname());

        order.setShipToLastName(account.getLastname());
//        order.setBillAddress1(address1);
//        order.setBillAddress2(address2);
        order.setShipAddress1(account.getAddress1());
        order.setShipAddress2(account.getAddress2());
//        order.setBillCity(city);
        order.setShipCity(account.getCity());
//        order.setBillState(state);
        order.setShipState(account.getState());
//        order.setBillZip(zip);
        order.setShipZip(account.getZip());
//        order.setBillCountry(country);
        order.setShipCountry(account.getCountry());

        session.setAttribute("order",order);

        if(request.getParameter("shippingAddressRequired") != null){
            request.getRequestDispatcher(SHIPPINGFORM).forward(request,response);
        }else{
            request.getRequestDispatcher(CONFIRMORDER).forward(request,response);
        }

    }
}
