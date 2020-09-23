package com.domain.SpringBurne2.models;

public class Room
{
    public enum priceRange {HIGH, MID, LOW}

    private Long roomId;
    private String name;
    private int rating;
    private priceRange range;
    private String city;
    private String description;
    private int beds;
    private boolean pool;
    private boolean restaurant;
    private boolean childClub;
    private boolean centralLocation;
    private boolean seaView;
    private int distanceToBeach;
    private int distanceToCenter;

    public Room(
            Long roomId,
            String name,
            int rating,
            priceRange range,
            String city,
            String description,
            int beds,
            boolean pool,
            boolean restaurant,
            boolean childClub,
            boolean centralLocation,
            boolean seaView,
            int distanceToBeach,
            int distanceToCenter)
    {
        this.roomId = roomId;
        this.name = name;
        this.rating = rating;
        this.range = range;
        this.city = city;
        this.description = description;
        this.beds = beds;
        this.pool = pool;
        this.restaurant = restaurant;
        this.childClub = childClub;
        this.centralLocation = centralLocation;
        this.seaView = seaView;
        this.distanceToBeach = distanceToBeach;
        this.distanceToCenter = distanceToCenter;
    }


    public Long getRoomId() { return roomId; }
    public String getName() { return name; }
    public int getRating() { return rating; }
    public priceRange getRange() { return range; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public int getBeds() { return beds; }
    public boolean hasPool() { return pool; }
    public boolean hasRestaurant() { return restaurant; }
    public boolean hasChildClub() { return childClub; }
    public boolean hasCentralLocation() { return centralLocation; }
    public boolean hasSeaView() { return seaView; }
    public int getDistanceToBeach() { return distanceToBeach; }
    public int getDistanceToCenter() { return distanceToCenter; }
    
    @Override
    public String toString()
    {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", range=" + range +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", beds=" + beds +
                ", pool=" + pool +
                ", restaurant=" + restaurant +
                ", childClub=" + childClub +
                ", centralLocation=" + centralLocation +
                ", seaView=" + seaView +
                ", distanceToBeach=" + distanceToBeach +
                ", distanceToCenter=" + distanceToCenter +
                '}';
    }
}
