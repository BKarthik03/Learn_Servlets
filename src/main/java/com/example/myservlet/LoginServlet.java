package com.example.myservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String userName_="", password_="";
        String DB = "users";

        Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        //JDBC
        try {
            Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            conn = DbConnect.getCon(DB);
            pt = conn.prepareStatement("select * from user where userId=? and userName=?;");
            pt.setString(1,request.getParameter("uname"));
            pt.setString(2,request.getParameter("pword"));

            rs = pt.executeQuery();
            while(rs.next()){
                userName_ = rs.getString(1);
                password_ = rs.getString(2);
            }


        }catch(SQLException e){
            pw.write("<h4>"+e+"</h4>");
        }

        String username = request.getParameter("uname");
        String password = request.getParameter("pword");
        if(username.equals(userName_) && password.equals(password_)){
            pw.println("Login SuccessFul");
            RequestDispatcher rd = request.getRequestDispatcher("dis");
            rd.forward(request, response);
        }

        else{
            pw.println("Login Failed");
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        }

        try {
            conn.close();
            pt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
