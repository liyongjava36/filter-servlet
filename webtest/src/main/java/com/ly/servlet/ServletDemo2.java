package com.ly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("aaa.txt");
//        BufferedReader read = new BufferedReader(new FileReader(new File(realPath)));
//        String line;
//        while ((line = read.readLine()) != null) {
//            String s = read.readLine();
//            System.out.println(s);
//        }






    }
}
