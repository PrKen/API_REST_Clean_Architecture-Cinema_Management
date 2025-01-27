package com.example.adapters.messaging;

import com.example.adapters.events.ReservationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "reservation-events", groupId = "cinema-group")
    public void consumeReservationEvent(ReservationEvent event) {
        System.out.println("Consumed event: " + event);
        // Traitement de l'événement (exemple : mise à jour de la base de données, envoi d'un email, etc.)
    }
}
