import java.util.*;
import java.io.*;

/**
 * Write a description of class EventDatabase here.
 * 
 * @author Jyhwoei Yang 
 * @version 15/04/2019
 */
public class EventDatabase
{    
    private ArrayList<Event> eventList; // should be private
    
    /** Default Constructor of Class EventDatabase
     * 
     */
    public EventDatabase()
    {
        //initialise the variables
        eventList = new ArrayList<Event>();
    }
    
    /**
     * A method to add Event to the list
     * 
     * @param Event the Event Object
     * @return 
     */
    public void addEvent(Event newEvent)
    {
        eventList.add(newEvent);
    } 
    
    /**
     * A method to delete Event from the list
     * 
     * @param delEventId the id of deleted event
     * @return 
     */
    public void deleteEvent(String delEventId)
    {        
        //remove()
        boolean isDeleted = false;
        for (int i = 0 ; i < getNumbersOfEvents() ; i++)
        {
            if(getEventList().get(i).getId().equals(delEventId))
            {
                System.out.println(getEventList().get(i).getId() + " are deleted.");
                getEventList().remove(i);
                isDeleted = true;
            }                        
        }        
        if (! isDeleted)
        {
            System.out.println(" No matched events are deleted."); 
        }
    } 
    
    /**
     * A method to edit event from the list
     * 
     * @param editEventId,editTitle,editYear,editPoster the id of edit event
     * @return 
     */
    public void editEvent(String editEventId, String editTitle, String editStartDate, String editEndDate, String editVenue, String editLocation)
    {        
        //set()
        boolean isEdited = false;
        for (int i = 0 ; i < getNumbersOfEvents() ; i++)
        {
            if(getEventList().get(i).getId().equals(editEventId))
            {
                System.out.println(getEventList().get(i).getId() + " are edited.");
                getEventList().get(i).setTitle(editTitle);
                getEventList().get(i).setStartDate(editStartDate);
                getEventList().get(i).setEndDate(editEndDate);
                getEventList().get(i).setVenue(editVenue);
                getEventList().get(i).setLocation(editLocation);
               
                isEdited = true;
            }                        
        }        
        if (! isEdited)
        {
            System.out.println(" No matched events are Edited."); 
        }
    }
    
    /**
     * A method to return elements from the event list
     * 
     * @param index the index
     * @return elements in the eventList
     */
    public Event getEvent(int index)
    {
        return eventList.get(index);
    }
    
    /**
     * A method to return the whole event list
     * 
     * @param 
     * @return the whole eventList
     */
    public ArrayList<Event> getEventList()
    {
        return eventList;
    }
    
    /**
     * A method to return the size of event list
     * 
     * @param
     * @return count number of Events
     */
    public int getNumbersOfEvents()
    {
        return eventList.size();
    }   
    
    /**
     * List all the events currently in the database on standard out.
     */
    public void listAll() 
    {
        for (int j = 0 ; j < eventList.size() ; j++)
        
            eventList.get(j).displayEventRecord();        
    }
    
    /**
     * A method to search event
     * 
     * @param searchTitle the searchTitle
     * @return resultList the resultList
     */
    public ArrayList<Event> searchEvent(String searchName) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Event> resultList = new ArrayList<Event>();
        
        for (int i = 0 ; i < getNumbersOfEvents(); i++)
        {
            if(getEventList().get(i).getId().toLowerCase().contains(searchName))
                resultList.add(getEventList().get(i));
            
        }
                
        return resultList;
    }
    
    /**
     * A method to set event in a event list
     * 
     * @param insertedEvent the insertedEvent, index the index
     * @return 
     */
    public void setEvent(Event insertedEvent, int index)
    {
        eventList.set(index, insertedEvent);
    }
    
    /**
    * Method to check Event Id repeatation
    * 
    * @param eventId the eventId
    * @return the boolean of Event Id repeatation
    */
    public boolean validEventId(String eventId) //method to check Event Id repeatation
    {
        //check if event name is not in database , and return false to break while loop
        for (int i = 0 ; i < getNumbersOfEvents() ; i++ )
        {
            if (eventId.equals(getEventList().get(i).getId()))
                return true;
        }
        
        return false;        
    }
}   
    