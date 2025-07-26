package com.example.Attribute;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        ServletContext sc = getServletContext();

//        String conAttr = (String) sc.getAttribute("message").toString();
        String conAttr = (String) sc.getAttribute("message");
        String reqAttr = req.getAttribute("ReqMessage").toString();

        pw.write("<h2>Here is the message from your native!!</h2>");
        pw.write("<h3>Context says: "+conAttr+" !!!</h3>");
        pw.write("<h3>RequestServlet Says: "+reqAttr+" !!!</h3><br/>");
    }
}
