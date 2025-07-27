package com.example.demo;


import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DBConfig {

    String URL = "jdbc:sqlserver://msi\\sqlexpress;databasename=Students";
    String username = "Sumedhavk";
    String pass="Sumedha04";
    String GET_DATE = "select 1 from dbo.Students";


    public Connection getDatabaseConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void getDetails(){
        System.out.println("getDetails");


        try {
            //Class.forName("com.mysql.jdbc.Driver");

            Connection databaseConnection = getDatabaseConnection();
            Statement statement = databaseConnection.createStatement();
            statement.execute(GET_DATE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
