package com.effectivo.messages_app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    String url = "jdbc:sqlserver://127.0.0.1\\sqlexpress:1433;databaseName=persistence_course";
    String user = "sa";
    String password = "<YourNewStrong@Passw0rd>";

    {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MS SQL Server ");
        } catch (SQLException throwables) {
            System.out.println("There is a problem, check the errors:");
            throwables.printStackTrace();
        }
    }

}
