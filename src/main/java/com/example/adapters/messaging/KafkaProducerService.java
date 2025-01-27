package com.example.adapters.messaging;

import com.example.adapters.events.ReservationEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, ReservationEvent> kafkaTemplate;
    private static final String TOPIC = "reservation-events";

    public KafkaProducerService(KafkaTemplate<String, ReservationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReservationEvent(ReservationEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Produced event: " + event);
    }
}
