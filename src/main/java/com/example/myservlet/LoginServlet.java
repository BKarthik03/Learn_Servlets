package com.example.myservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        String username = request.getParameter("uname");
        String password = request.getParameter("pword");
        if(username.equals("admin") && password.equals("admin")){
            pw.println("Login SuccessFul");
            RequestDispatcher rd = request.getRequestDispatcher("dis");
            rd.forward(request, response);
        }

        else{
            pw.println("Login Failed");
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        }
    }
}
