package com.example.Attribute;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        ServletContext context = getServletContext();
        context.setAttribute("message","Myself RequestServlet");

        req.setAttribute("ReqMessage","Forwarding to you!!");
        RequestDispatcher rd = req.getRequestDispatcher("disAttr");
        rd.forward(req,res);
    }
}
