package com.example.chat.task.model;

import java.awt.*;
import java.time.LocalDate;

public class ChatMessage {
    private MessageType messageType;
    private String content;
    private String sender;
    private String receiver;
    private LocalDate localDate = LocalDate.now();
    public enum MessageType{
        CHAT,
        JOIN,
        LEAVE,
        TYPE
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
