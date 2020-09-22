package com.domain.SpringBurne2.models;

import java.util.Date;

public class Reservation
{
    private Long reservationId;
    private Long customerId;
    private Long roomId;
    private Date startDate;
    private Date endDate;

    public Reservation(Long reservationId,
                       Long customerId,
                       Long roomId,
                       Date startDate,
                       Date endDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getReservationId() { return reservationId; }
    public Long getCustomerId() { return customerId; }
    public Long getRoomId() { return roomId; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }

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
