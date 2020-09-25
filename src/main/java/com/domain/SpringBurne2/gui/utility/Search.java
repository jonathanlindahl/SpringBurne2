package com.domain.SpringBurne2.gui.utility;

import java.util.Date;

public class Search
{
    private final Date startDate;
    private final Date endDate;
    
    private final int distanceToBeach;
    private final int distanceToCenter;
    
    private final boolean pool;
    private final boolean restaurant;
    private final boolean childClub;
    private final boolean centralLocation;
    private final boolean seaView;
    
    private final boolean halfBoard;
    private final boolean fullBoard;
    private final boolean allInclusive;
    
    public Search(
            Date startDate,
            Date endDate,
            int distanceToBeach,
            int distanceToCenter,
            boolean pool,
            boolean restaurant,
            boolean childClub,
            boolean centralLocation,
            boolean seaView,
            boolean halfBoard,
            boolean fullBoard,
            boolean allInclusive)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.distanceToBeach = distanceToBeach == 0 ? 1000000 : distanceToBeach;
        this.distanceToCenter = distanceToCenter == 0 ? 1000000 : distanceToCenter;
        this.pool = pool;
        this.restaurant = restaurant;
        this.childClub = childClub;
        this.centralLocation = centralLocation;
        this.seaView = seaView;
        this.halfBoard = halfBoard;
        this.fullBoard = fullBoard;
        this.allInclusive = allInclusive;
    }
    
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public int getDistanceToBeach() { return distanceToBeach; }
    public int getDistanceToCenter() { return distanceToCenter; }
    public boolean isPool() { return pool; }
    public boolean isRestaurant() { return restaurant; }
    public boolean isChildClub() { return childClub; }
    public boolean isCentralLocation() { return centralLocation; }
    public boolean isSeaView() { return seaView; }
    public boolean isHalfBoard() { return halfBoard; }
    public boolean isFullBoard() { return fullBoard; }
    public boolean isAllInclusive() { return allInclusive; }
}
