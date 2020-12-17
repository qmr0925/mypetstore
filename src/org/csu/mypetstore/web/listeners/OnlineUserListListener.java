package org.csu.mypetstore.web.listeners;

import org.csu.mypetstore.domain.User;
import org.csu.mypetstore.domain.UserFind;
import org.csu.mypetstore.service.UserFindService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class OnlineUserListListener implements ServletContextListener, HttpSessionAttributeListener {
    private UserFind userFind;
    private UserFindService userFindService;

      public void contextInitialized(ServletContextEvent sec){
          userFindService = new UserFindService();
          ServletContext servletContext = sec.getServletContext();
          servletContext.setAttribute("userCounter",new AtomicInteger());
      }

      public void contextDestroyed(ServletContextEvent sec){
          ServletContext servletContext = sec.getServletContext();
          servletContext.removeAttribute("userCounter");
      }

      public void attributeAdded(HttpSessionBindingEvent e){
          String name = e.getName();
          ServletContext servletContext = e.getSession().getServletContext();

          if(name.equals("user")){
              AtomicInteger userCounter = (AtomicInteger)servletContext.getAttribute("userCounter");
              int userCount = userCounter.incrementAndGet();
              System.out.println("userCount incremented to:" + userCount);

              User user = (User) e.getSession().getAttribute("user");
              userFind = new UserFind();
              userFind.setUsername(user.getUsername());
              userFind.setLoginTime(new Timestamp(new Date().getTime()).toString());
              e.getSession().setAttribute("userFind", userFind);
          }
      }

    public void attributeRemoved(HttpSessionBindingEvent e) {
        String name = e.getName();
        ServletContext servletContext = e.getSession().getServletContext();

        if(name.equals("user")) {
            AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
            int userCount = userCounter.decrementAndGet();
            System.out.println("---------userCount decremented to:" + userCount);
            e.getSession().removeAttribute("userFind");
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent e) {
    }
}
