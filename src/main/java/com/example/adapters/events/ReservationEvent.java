package com.example.adapters.events;

public class ReservationEvent {
    private Long reservationId;
    private String status;

    public ReservationEvent(Long reservationId, String status) {
        this.reservationId = reservationId;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationEvent{" +
                "reservationId=" + reservationId +
                ", status='" + status + '\'' +
                '}';
    }
}
