package com.domain.SpringBurne2.models;

import java.util.Date;

public class Reservation
{
    private Long reservationId;
    private Long customerId;
    private Long roomId;
    private String startDate;
    private String endDate;

    public Reservation(Long reservationId,
                       Long customerId,
                       Long roomId,
                       String startDate,
                       String endDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getReservationId() { return reservationId; }
    public Long getCustomerId() { return customerId; }
    public Long getRoomId() { return roomId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", customerId=" + customerId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
