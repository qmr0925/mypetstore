package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.util.JavaMailUtil;
import org.csu.mypetstore.util.RandomNumberUtil;
import org.csu.mypetstore.util.htmlText;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class SendVCodeServlet extends HttpServlet {
    private static String REGISTER_FORM = "/WEB-INF/jsp/RegisterForm.jsp";

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{

        System.out.println("邮箱发送功能");
        String reminder = null;
        String vCode = null;
        String email = null;
        try{
            //获取email的值
            email = request.getParameter("email");
            JavaMailUtil.receiveMailAccount = email;

            Properties pops = new Properties();
            pops.setProperty("mail.debug","true");
            pops.setProperty("mail.smtp.auth","true");
            pops.setProperty("mail.host",JavaMailUtil.emailSMTPHost);
            pops.setProperty("mail.transport.protocol","smtp");
            Session session = Session.getInstance(pops);
            session.setDebug(true);
            vCode = RandomNumberUtil.getRandomNumber();
            System.out.println("邮箱验证码" + vCode);
            String html = htmlText.html(vCode);
            MimeMessage message = JavaMailUtil.creatMimeMessage(session, JavaMailUtil.emailAccount,
                    JavaMailUtil.receiveMailAccount,html);
            Transport transport = session.getTransport();
            transport.connect(JavaMailUtil.emailAccount,JavaMailUtil.emailPassword);
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();

            reminder = "验证码发送成功";
            request.setAttribute("reminder",reminder);
            request.getSession().setAttribute("vCode",vCode);
        }
        catch (MessagingException m){
            m.printStackTrace();
            request.getSession().setAttribute("error","邮件发送失败");
        }
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        doGet(request,response);
    }
}
