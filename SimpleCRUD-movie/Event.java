import java.util.*;

/**
 * Design a class Conference
 * 
 * @author Jyh-woei Yang 
 * @version 15/04/2019
 */
public class Event
//Id, Title, Start Date, End Date, Venue, Location
{
    // instance variables - replace the example below with your own
    private String id;
    private String title;
    private String startDate;
    private String endDate;
    private String venue;
    private String location;

    /**
     * Default Constructor for objects of class Record
     */
    public Event()
    {
        // initialise instance variables
        id = "";
        title = "";
        startDate = "";
        endDate = "";
        venue = "";
        location = "";
    }
    
    /**
     * A method to test displaying object displayEventRecord attibutes
     * 
     * @param
     * @return 
     */
    public void displayEventRecord()
    {
        //method to test displaying attributes of the Event
        System.out.print(id + ",");
        System.out.print(title + ",");
        System.out.print(startDate + ",");
        System.out.print(endDate + ",");
        System.out.print(venue + ",");
        System.out.print(location + "\n");
    }    
        
    /**
     * A method to return id
     * 
     * @param
     * @return id 
     */
    public String getId()
    {
        //method to get id
        return id;
    }
   
    /**
     * A method to return title 
     * 
     * @param
     * @return title  
     */
    public String getTitle()
    {
        //method to get title
        return title;
    }
    
    /**
     * A method to return startDate
     * 
     * @param
     * @return startDate 
     */
    public String getStartDate()
    {
        // method to get startDate
        return startDate;
    }
    
    /**
     * A method to return endDate
     * 
     * @param
     * @return endDate 
     */
    public String getEndDate()
    {
        // method to get endDate
        return endDate;
    }
    
        /**
     * A method to return venue
     * 
     * @param
     * @return venue 
     */
    public String getVenue()
    {
        // method to get venue
        return venue;
    }
    
    /**
     * A method to return location
     * 
     * @param
     * @return location 
     */
    public String getLocation()
    {
        // method to get location
        return location;
    }
    
    /**
     * A method to set event id
     * 
     * @param eventId the Event id
     * @return 
     */
    public void setId(String eventId)
    {
        //method to set eventId
        id = eventId;
    }
    
    /**
     * A method to set title
     * 
     * @param eventTitle the Event title
     * @return  
     */
    public void setTitle(String eventTitle)
    {
        //method to set a eventTitle
        title = eventTitle;
    }
    
    /**
     * A method to set startDate
     * 
     * @param  eventStartDate the Event startDate
     * @return      
     */
    public void setStartDate(String eventStartDate)
    {
        //method to set eventStartDate
        startDate = eventStartDate;
    }
    
    /**
     * A method to set endDate
     * 
     * @param  eventEndDate the Event endDate
     * @return      
     */
    public void setEndDate(String eventEndDate)
    {
        //method to set eventEndDate
        endDate = eventEndDate;
    }
    
    /**
     * A method to set venue
     * 
     * @param  eventVenue the Event venue
     * @return      
     */
    public void setVenue(String eventVenue)
    {
        //method to set eventEndDate
        venue = eventVenue;
    }
    
    /**
     * A method to set location
     * 
     * @param  eventLocation the Event location
     * @return      
     */
    public void setLocation(String eventLocation)
    {
        //method to set eventLocation
        location = eventLocation;
    }
        
}
