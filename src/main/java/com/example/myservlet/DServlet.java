package com.example.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        String username = req.getParameter("uname");
        pw.println("<h1>Welcome "+username+"!</h1>");

        try{
            Connection conn = DbConnect.getCon("University");
            PreparedStatement pt = conn.prepareStatement("select * from userDetails where uId=?;");
            pt.setString(1,username);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){
                pw.println("<h2>User Details</h2>");
                pw.println("<h3>Name: "+rs.getString("uName")+"</h3>");
                pw.println("<h3>Phone: "+rs.getString("uPhone")+"</h3>");
                pw.println("<h3>Email ID: "+rs.getString("uMail")+"</h3>");
            }

            rs.close();
            pt.close();
            conn.close();

        }catch(SQLException s){
            pw.println("<h1>Welcome "+s+"!</h1>");
        }

    }
}
