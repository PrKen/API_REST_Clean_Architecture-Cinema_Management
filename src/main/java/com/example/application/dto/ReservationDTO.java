package com.example.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representation of a reservation.")
public class ReservationDTO {

    @Schema(description = "Unique identifier of the reservation.", example = "1")
    private Long id;

    @Schema(description = "Client ID associated with the reservation.", example = "1")
    private Long clientId;

    @Schema(description = "Session ID associated with the reservation.", example = "2")
    private Long seanceId;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getSeanceId() { return seanceId; }
    public void setSeanceId(Long seanceId) { this.seanceId = seanceId; }
}
