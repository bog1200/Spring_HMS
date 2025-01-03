package com.example.appointment_module.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class AppointmentWebsocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public AppointmentWebsocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/appointments-ws")
    @CrossOrigin("*")
    public void sendAppointmentNotification(String message) {
        messagingTemplate.convertAndSend("/topic/appointments", message);
    }
}
