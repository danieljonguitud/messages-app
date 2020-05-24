package com.effectivo.messages_app.persistence.dao;

import com.effectivo.messages_app.persistence.DbConfig;
import com.effectivo.messages_app.persistence.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao {

    public static void createMessageDb(Message message){
        DbConfig db_connect = new DbConfig();

        try(Connection connection = db_connect.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO [dbo].[messages] ([message], [author_message]) VALUES (?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor_message());
                ps.executeUpdate();
                System.out.println("Message created");

            } catch(SQLException e){
                System.out.println(e);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void readMessagesDb(){
        DbConfig db_connect = new DbConfig();

        try(Connection connection = db_connect.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT * FROM messages";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Message: " + rs.getString("message"));
                    System.out.println("Author: " + rs.getString("author_message"));
                    System.out.println("Date: " + rs.getString("message_date"));
                    System.out.println("");
                }

            } catch(SQLException e){
                System.out.println(e);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteMessageDb(int id){
        DbConfig db_connect = new DbConfig();
        try(Connection connection = db_connect.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM [dbo].[messages] WHERE [id] = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("Message deleted successfully");

            } catch(SQLException e){
                System.out.println(e);
                System.out.println("Message failed to be deleted");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessageDb(String message, int id){
        DbConfig db_connect = new DbConfig();
        try(Connection connection = db_connect.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE [dbo].[messages] SET [message] = ? WHERE [id] = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, message);
                ps.setInt(2, id);
                ps.executeUpdate();
                System.out.println("Message updated successfully");

            } catch(SQLException e){
                System.out.println(e);
                System.out.println("Message failed to be updated");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

}
