import java.util.*;

/**
 * Design a class Conference
 * 
 * @author Jyh-woei Yang 
 * @version 15/04/2019
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String id;
    private String title;
    private String year;
    private String poster;

    /**
     * Default Constructor for objects of class Record
     */
    public Movie()
    {
        // initialise instance variables
        id = "";
        title = "";
        year = "";
        poster = "";
    }
    
    /**
     * A method to test displaying object displayMovieRecord attibutes
     * 
     * @param
     * @return 
     */
    public void displayMovieRecord()
    {
        //method to test displaying attributes of the Movie
        System.out.print(id + ",");
        System.out.print(title + ",");
        System.out.print(year + ",");
        System.out.print(poster + "\n");
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
     * A method to return year
     * 
     * @param
     * @return year 
     */
    public String getYear()
    {
        // method to get year
        return year;
    }
    
    /**
     * A method to return poster
     * 
     * @param
     * @return poster 
     */
    public String getPoster()
    {
        // method to get poster
        return poster;
    }
    
    /**
     * A method to set movie id
     * 
     * @param movieId the Movie id
     * @return 
     */
    public void setId(String movieId)
    {
        //method to set movieId
        id = movieId;
    }
    
    /**
     * A method to set title
     * 
     * @param movieTitle the Movie title
     * @return  
     */
    public void setTitle(String movieTitle)
    {
        //method to set a movieTitle
        title = movieTitle;
    }
    
    /**
     * A method to set year
     * 
     * @param  movieYear the Movie year
     * @return      
     */
    public void setYear(String movieYear)
    {
        //method to set MovieYear
        year = movieYear;
    }
    
    /**
     * A method to set poster
     * 
     * @param  moviePoster the Movie poster
     * @return      
     */
    public void setPoster(String moviePoster)
    {
        //method to set moviePoster
        poster = moviePoster;
    }
        
}
