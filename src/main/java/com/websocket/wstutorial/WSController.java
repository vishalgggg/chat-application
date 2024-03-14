package com.websocket.wstutorial;

import com.websocket.wstutorial.dto.Message;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

    @Autowired
    private WSService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        System.out.println(message.getMessageContent());
        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-messagess/{id}")
    public void sendPrivateMessage(@PathVariable final String id,
                                   @RequestBody final Message message) {
     System.out.println(message.getMessageContent());
     service.notifyUser(id, message.getMessageContent());
    }
}
