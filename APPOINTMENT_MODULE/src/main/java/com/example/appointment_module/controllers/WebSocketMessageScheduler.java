package com.example.appointment_module.controllers;

import com.example.appointment_module.domain.Appointment;
import com.example.appointment_module.domain.AppointmentType;
import com.example.appointment_module.services.AppointmentService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Component
public class WebSocketMessageScheduler {
    private final SimpMessagingTemplate messagingTemplate;
    private final AppointmentService appointmentService;
    public WebSocketMessageScheduler(SimpMessagingTemplate messagingTemplate, AppointmentService appointmentService) {
        this.messagingTemplate = messagingTemplate;
        this.appointmentService = appointmentService;
    }
    @Scheduled(fixedDelay = 30000)
    public void sendMessageToWebSocketClients() {
        Optional<Set<Appointment>> appointments = appointmentService.findStartingAppointments();
        Appointment test = new Appointment(123L, 10L, Timestamp.from(new Date().toInstant()), AppointmentType.SURGERY);
        test.setId(1L);
        messagingTemplate.convertAndSend("/topic/"+test.getIdPatient(), test);
        messagingTemplate.convertAndSend("/topic/"+test.getIdDoctor(), test);

        appointments.ifPresent(appointmentSet -> {
            for (Appointment appointment : appointmentSet) {
                messagingTemplate.convertAndSend("/topic/"+appointment.getIdPatient(), appointment);
                messagingTemplate.convertAndSend("/topic/"+appointment.getIdDoctor(), appointment);
       // messagingTemplate.convertAndSend("/topic/heartbeat", "Hello from server");
             }
          });
    }
}
