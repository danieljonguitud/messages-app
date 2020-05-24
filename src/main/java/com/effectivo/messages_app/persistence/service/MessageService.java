package com.effectivo.messages_app.persistence.service;

import com.effectivo.messages_app.persistence.dao.MessageDao;
import com.effectivo.messages_app.persistence.model.Message;

import java.util.Scanner;

public class MessageService {
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String message = sc.nextLine();

        System.out.println("Your name");
        String name = sc.nextLine();

        Message registry = new Message();
        registry.setMessage(message);
        registry.setAuthor_message(name);

        MessageDao.createMessageDb(registry);
        
    }

    public static void listMessages(){
        MessageDao.readMessagesDb();
    }

    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the ID of the message you want to delete");
        int id = sc.nextInt();

        MessageDao.deleteMessageDb(id);
    }

    public static void editMessage(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert the id of the message you would like to edit");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Write your new message");
        String message = sc.nextLine();


        MessageDao.updateMessageDb(message, id);
    }
}
