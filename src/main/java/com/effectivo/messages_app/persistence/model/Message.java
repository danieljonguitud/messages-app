package com.effectivo.messages_app.persistence.model;

public class Message {
    private int id;
    private String message;
    private String author_message;
    private String message_date;

    public Message(){

    }

    public Message(String message, String author_message, String message_date) {
        this.message = message;
        this.author_message = author_message;
        this.message_date = message_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_message() {
        return author_message;
    }

    public void setAuthor_message(String author_message) {
        this.author_message = author_message;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }
}

