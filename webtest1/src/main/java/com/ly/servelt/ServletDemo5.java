package com.ly.servelt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/servletDemo5")
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + fileName);
        String mimeType = servletContext.getMimeType(fileName);
        resp.setContentType(mimeType);
        String encode = URLEncoder.encode(fileName, "UTF-8");
        resp.setHeader("content-disposition", "attachment;filename=" + encode);
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream outputStream = resp.getOutputStream();

        byte[] bytes = new byte[1024 * 4];
        int len = 0;

        while((len = fis.read(bytes)) != -1){
            outputStream.write(bytes);
        }


    }
}
