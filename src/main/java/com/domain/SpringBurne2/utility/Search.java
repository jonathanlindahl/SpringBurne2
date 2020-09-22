package com.domain.SpringBurne2.utility;

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
    
    public Search(
            Date startDate,
            Date endDate,
            int distanceToBeach,
            int distanceToCenter,
            boolean pool,
            boolean restaurant,
            boolean childClub,
            boolean centralLocation,
            boolean seaView)
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
    }
    
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public int getDistanceToBeach() { return distanceToBeach; }
    public int getDistanceToCenter() { return distanceToCenter; }
    public boolean getPool() { return pool; }
    public boolean getRestaurant() { return restaurant; }
    public boolean getChildClub() { return childClub; }
    public boolean getCentralLocation() { return centralLocation; }
    public boolean getSeaView() { return seaView; }
}
