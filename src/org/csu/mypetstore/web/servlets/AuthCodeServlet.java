package org.csu.mypetstore.web.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class AuthCodeServlet extends HttpServlet {
    private static final long serialVersionID = 1L;
    private static final int WIDTH = 130;
    private static final int HEIGHT = 30;

    Random ran = new Random();

    @SuppressWarnings("unused")
    private String  setWriteDate(Graphics g){
        g.setFont(new Font("楷体", Font.BOLD,20));
        int x = 10;
        int y = 20;
        String result = "";
        for(int i = 0;i < 4;i++){
            String str = String.valueOf(ran.nextInt(10));
            result += str;
            g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));

            int degree = ran.nextInt()%40;
            ((Graphics2D)g).rotate(degree*Math.PI/180,x,y);
            g.drawString(str,x,y);
            ((Graphics2D)g).rotate(-degree*Math.PI/180,x,y);
            x = x + 30;
        }
        return result;
    }

    private void setRandomLine(Graphics g){
        g.setColor(Color.white);
        for(int i = 0;i < 20;i++){
            int x1 = ran.nextInt(WIDTH);
            int y1 = ran.nextInt(HEIGHT);
            int x2 = ran.nextInt(WIDTH);
            int y2 = ran.nextInt(HEIGHT);
            g.drawLine(x1,y1,x2,y2);
        }
    }

    private void setBorder(Graphics g){
        g.setColor(Color.lightGray);
        g.drawRect(1,1,WIDTH-2,HEIGHT-2);
    }

    private void setBackground(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        String authCode = "";
        setBackground(g);
        setBorder(g);
        setRandomLine(g);
        authCode = setWriteDate(g);
        request.getSession().setAttribute("authCode",authCode);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-control","no-cache");
        response.setIntHeader("Expires",-1);
        g.dispose();
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }
}
