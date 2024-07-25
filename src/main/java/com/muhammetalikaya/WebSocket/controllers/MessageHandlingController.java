package com.muhammetalikaya.WebSocket.controllers;

import com.muhammetalikaya.WebSocket.models.Message;
import com.muhammetalikaya.WebSocket.models.Receiver;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageHandlingController {

    @MessageMapping("/mesaj")
    @SendTo("/topic/mesajlar")
    public Receiver getReceiver(Message message) throws InterruptedException {
        Thread.sleep(1000);
        return new Receiver("Mesaj...: "+ HtmlUtils.htmlEscape(message.getMessage()));
    }
}
