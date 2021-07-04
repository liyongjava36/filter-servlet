package com.ly.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class FilterTest implements Filter {
    private List<String> list;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("aaa.txt");

        BufferedReader reader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(realPath);
            reader = new BufferedReader(fileReader);
            String line;
            list = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        for (String s : list) {
//            System.out.println(s);
//        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
