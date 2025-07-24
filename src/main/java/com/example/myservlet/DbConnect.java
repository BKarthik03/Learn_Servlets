package com.example.myservlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    static Connection conn = null;


    public static Connection getCon(String DB){
        try{
            Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB,"root","yourpassword");
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return conn;
    }

}
