package com.websocket.wstutorial;

import com.websocket.wstutorial.dto.ResponseMessage;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WSService {

    private final SimpMessagingTemplate messagingTemplate;
    //private final NotificationService notificationService;

    // @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
       
    }

    @SuppressWarnings("null")
    public void notifyFrontend(final String message) {
        ResponseMessage response = (new ResponseMessage(message));
        //notificationService.sendGlobalNotification();
        System.out.println(response.getContent());
        messagingTemplate.convertAndSend("/topic/messages", response);
    }

    @SuppressWarnings("null")
    public void notifyUser(@NonNull final String id, final String message) {
        // ResponseMessage response = new ResponseMessage(message);
        ResponseMessage response = new ResponseMessage(message);
        
                                                // notificationService.sendPrivateNotification(id);
        messagingTemplate.convertAndSendToUser(id, "/topic/private-messages", response);
    }
}
