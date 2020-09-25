package com.domain.SpringBurne2.models;

import java.util.Date;

public class Reservation
{
    // TODO: make final
    private Long reservationId;
    private Long customerId;
    private Long roomId;
    private String startDate;
    private String endDate;
    private boolean halfBoard;
    private boolean fullBoard;
    private boolean allInclusive;
    private int extraBeds;
    private int extraCribs;

    public Reservation(Long reservationId,
                       Long customerId,
                       Long roomId,
                       String startDate,
                       String endDate,
                       boolean halfBoard,
                       boolean fullBoard,
                       boolean allInclusive,
                       int extraBeds,
                       int extraCribs)
    {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.halfBoard = halfBoard;
        this.fullBoard = fullBoard;
        this.allInclusive = allInclusive;
        this.extraBeds = extraBeds;
        this.extraCribs = extraCribs;
    }

    public Long getReservationId() { return reservationId; }
    public Long getCustomerId() { return customerId; }
    public Long getRoomId() { return roomId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public boolean isHalfBoard() { return halfBoard; }
    public boolean isFullBoard() { return fullBoard; }
    public boolean isAllInclusive() { return allInclusive; }
    public int getExtraBeds() { return extraBeds; }
    public int getExtraCribs() { return extraCribs; }

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
