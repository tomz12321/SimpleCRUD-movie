import java.util.*;
import java.io.*;

/**
 * Write a description of class MovieDatabase here.
 * 
 * @author Jyhwoei Yang 
 * @version 15/04/2019
 */
public class MovieDatabase
{    
    private ArrayList<Movie> movieList; // should be private
    
    /** Default Constructor of Class MovieDatabase
     * 
     */
    public MovieDatabase()
    {
        //initialise the variables
        movieList = new ArrayList<Movie>();
    }
    
    /**
     * A method to add Movie to the list
     * 
     * @param newMovie the Movie Object
     * @return 
     */
    public void addMovie(Movie newMovie)
    {
        movieList.add(newMovie);
    } 
    
    /**
     * A method to delete Movie from the list
     * 
     * @param delMovieId the id of deleted movie
     * @return 
     */
    public void deleteMovie(String delMovieId)
    {        
        //remove()
        boolean isDeleted = false;
        for (int i = 0 ; i < getNumbersOfMovies() ; i++)
        {
            if(getMovieList().get(i).getId().equals(delMovieId))
            {
                System.out.println(getMovieList().get(i).getId() + " are deleted.");
                getMovieList().remove(i);
                isDeleted = true;
            }                        
        }        
        if (! isDeleted)
        {
            System.out.println(" No matched movies are deleted."); 
        }
    } 
    
    /**
     * A method to edit Movie from the list
     * 
     * @param editMovieId,editTitle,editYear,editPoster the id of edit movie
     * @return 
     */
    public void editMovie(String editMovieId, String editTitle, String editYear, String editPoster)
    {        
        //set()
        boolean isEdited = false;
        for (int i = 0 ; i < getNumbersOfMovies() ; i++)
        {
            if(getMovieList().get(i).getId().equals(editMovieId))
            {
                System.out.println(getMovieList().get(i).getId() + " are edited.");
                getMovieList().get(i).setTitle(editTitle);
                getMovieList().get(i).setYear(editYear);
                getMovieList().get(i).setPoster(editPoster);
               
                isEdited = true;
            }                        
        }        
        if (! isEdited)
        {
            System.out.println(" No matched movies are Edited."); 
        }
    }
    
    /**
     * A method to return elements from the movie list
     * 
     * @param index the index
     * @return elements in the movieList
     */
    public Movie getMovie(int index)
    {
        return movieList.get(index);
    }
    
    /**
     * A method to return the whole movie list
     * 
     * @param 
     * @return the whole movieList
     */
    public ArrayList<Movie> getMovieList()
    {
        return movieList;
    }
    
    /**
     * A method to return the size of movie list
     * 
     * @param
     * @return count number of Movies
     */
    public int getNumbersOfMovies()
    {
        return movieList.size();
    }   
    
    /**
     * List all the movies currently in the database on standard out.
     */
    public void listAll() 
    {
        for (int j = 0 ; j < movieList.size() ; j++)
        
            movieList.get(j).displayMovieRecord();        
    }
    
    /**
     * A method to search movie
     * 
     * @param searchTitle the searchTitle
     * @return resultList the resultList
     */
    public ArrayList<Movie> searchMovie(String searchName) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Movie> resultList = new ArrayList<Movie>();
        
        for (int i = 0 ; i < getNumbersOfMovies(); i++)
        {
            if(getMovieList().get(i).getId().toLowerCase().contains(searchName))
                resultList.add(getMovieList().get(i));
            
        }
                
        return resultList;
    }
    
    /**
     * A method to set movie in a movie list
     * 
     * @param insertedMovie the insertedMovie, index the index
     * @return 
     */
    public void setMovie(Movie insertedMovie, int index)
    {
        movieList.set(index, insertedMovie);
    }
    
    /**
    * Method to check Movie Id repeatation
    * 
    * @param movieId the movieId
    * @return the boolean of Movie Id repeatation
    */
    public boolean validMovieId(String movieId) //method to check Movie Id repeatation
    {
        //check if movie id is not in database , and return false to break while loop
        for (int i = 0 ; i < getNumbersOfMovies() ; i++ )
        {
            if (movieId.equals(getMovieList().get(i).getId()))
                return true;
        }
        
        return false;        
    }
}   
    