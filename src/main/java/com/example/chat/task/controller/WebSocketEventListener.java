package com.example.chat.task.controller;

import com.example.chat.task.model.ChatMessage;
import com.example.chat.task.security.CurrentUser;
import com.example.chat.task.security.UserPrincipal;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    @PreAuthorize("hasRole('USER')")
    public void handleWebSocketConnectListener(@CurrentUser UserPrincipal userPrincipal, SessionConnectedEvent event){
        logger.info("New websocket connection");
    }

    @EventListener
    @PreAuthorize("hasRole('USER')")
    public void handleWebSocketDisconnectListener(@CurrentUser UserPrincipal userPrincipal,SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            logger.info("Disconnected " + username);
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setMessageType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);

            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
    }

}
