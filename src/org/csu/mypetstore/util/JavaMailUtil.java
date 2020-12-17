package org.csu.mypetstore.util;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

public class JavaMailUtil {
    public static String emailAccount = "2577048181@qq.com";
    public static String emailPassword = "atqlkjtvoelfdifh";
    public static String emailSMTPHost = "smtp.qq.com";
    public static String receiveMailAccount = "";

    public static MimeMessage creatMimeMessage(Session session, String sendMail, String receiveMail, String html)throws
            MessagingException, IOException{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail,"JPetStore","UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,receiveMail,"UTF-8"));
        message.setSubject("邮箱验证","UTF-8");
        message.setContent(html,"text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}

