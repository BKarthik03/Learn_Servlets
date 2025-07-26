package com.example.ParamServlet;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class ParamServlet extends GenericServlet{
    int count;
    public void init(ServletConfig sc){
        count = Integer.parseInt(sc.getInitParameter("count"));
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.write("<h2>The value of count is:"+count+"</h2>");
        pw.close();
    }

    public void destroy(){

    }
}
