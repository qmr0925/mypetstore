package org.csu.mypetstore.web.listeners;

import org.csu.mypetstore.domain.UserFind;
import org.csu.mypetstore.service.UserFindService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebListener
public class PrefStatListener implements ServletRequestListener {
    private UserFindService userFindService;

    public PrefStatListener(){
        userFindService = new UserFindService();
    }

    @Override
    public void requestInitialized(ServletRequestEvent sec){
        ServletRequest servletRequest = sec.getServletRequest();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        UserFind userFind = (UserFind) httpServletRequest.getSession().getAttribute("userFind");
        HttpSession session = httpServletRequest.getSession();
        servletRequest.setAttribute("start",System.nanoTime());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sec){
        ServletRequest servletRequest = sec.getServletRequest();
        Long start = (Long) servletRequest.getAttribute("start");
        Long end = System.nanoTime();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String uri = httpServletRequest.getRequestURI();
        System.out.println("time taken to execute " + uri
        + ":" + ((end-start)/1000) + "microseconds");

        System.out.println("bot");
        UserFind userFind = (UserFind) httpServletRequest.getSession().getAttribute("userFind");
        if(userFind != null) {
            String strUrl = "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath() + httpServletRequest.getServletPath() + "?" + (httpServletRequest.getQueryString());
            System.out.println(userFind + strUrl);
            userFindService.insertUserFindByUserNameAndLoginTimeAndUrl(userFind.getUsername(), userFind.getLoginTime().toString(), strUrl);
        }
    }
}

