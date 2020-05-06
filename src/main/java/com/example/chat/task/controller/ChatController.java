package com.example.chat.task.controller;

import com.example.chat.task.model.ChatMessage;
import com.example.chat.task.security.CurrentUser;
import com.example.chat.task.security.UserPrincipal;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    @PreAuthorize("hasRole('USER')")
    public ChatMessage addUser(@CurrentUser UserPrincipal userPrincipal,@Payload ChatMessage chatMessage){

        return chatMessage;
    }

    @MessageMapping("/addUser")
    @SendTo("topic/public")
    @PreAuthorize("hasRole('USER')")
    public ChatMessage addUser(@CurrentUser UserPrincipal userPrincipal,@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }

    /**
     * todo add private chat
     */
}
