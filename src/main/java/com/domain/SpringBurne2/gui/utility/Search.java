package com.domain.SpringBurne2.gui.utility;

import java.util.Date;

public class Search
{
    private final String startDate;
    private final String endDate;
    
    private final int distanceToBeach;
    private final int distanceToCenter;
    
    private final boolean pool;
    private final boolean restaurant;
    private final boolean childClub;
    private final boolean centralLocation;
    private final boolean seaView;
    
    public Search(
            String startDate,
            String endDate,
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
    
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public int getDistanceToBeach() { return distanceToBeach; }
    public int getDistanceToCenter() { return distanceToCenter; }
    public boolean isPool() { return pool; }
    public boolean isRestaurant() { return restaurant; }
    public boolean isChildClub() { return childClub; }
    public boolean isCentralLocation() { return centralLocation; }
    public boolean isSeaView() { return seaView; }
}
