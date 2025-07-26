package com.example.ContextServlet;
import jakarta.servlet.*;
import java.io.PrintWriter;
import java.io.IOException;
public class ContextServlet extends GenericServlet {

    ServletContext sct = null;
    public void init(ServletConfig sc){
        sct = sc.getServletContext();
    }

    public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException{
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.print("<h4>The Name is: "+sct.getInitParameter("name")+"</h4>");
        pw.close();
    }

    public void destroy(){

    }
}
