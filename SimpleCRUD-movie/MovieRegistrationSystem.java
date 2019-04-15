import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Create a class for Conference Information System.
 * 
 * @author Jyh-woei Yang 
 * @version 15/04/2019
 */
public class MovieRegistrationSystem
{
    // instance variables - replace the example below with your own
    private MovieDatabase newMovieList;
    private EventDatabase newEventList;

    /**
     * Default Constructor for objects of class User System
     */
    public MovieRegistrationSystem()
    {
        // initialise instance variables
        newMovieList = new MovieDatabase();
        newEventList = new EventDatabase();
    }    

    /**
     * A method to add movie to the database system
     * 
     * @param
     * @return 
     */
    public void addMovie()
    {
        //input
        Scanner input = new Scanner(System.in);

        System.out.println("=== Add Movie ===");
        System.out.println("Please insert movie id :");        
        String newMovieId = input.nextLine();

        //valid addMovieName if existed , Error message
        while (validMovieId(newMovieId))
            newMovieId = input.nextLine();                  

        //valid addUser if blank , Error message    
        while (validBlank(newMovieId,"User Name"))
        {
            newMovieId = input.nextLine();
            //valid addUserName if existed , Error message
            while (validMovieId(newMovieId))
                newMovieId = input.nextLine(); 
        }        
        System.out.println("Please insert movie title :");

        //input Movie's newTitle
        String newMovieTitle = input.nextLine();

        while (validBlank(newMovieTitle,"Movie Title"))
            newMovieTitle = input.nextLine();

        System.out.println("Please insert movie year :");

        //input Movie's Year
        String newMovieYear = input.nextLine();

        while (validBlank(newMovieYear,"Movie Year"))
            newMovieYear = input.nextLine();
        
        System.out.println("Please insert movie poster :");
            
        //input Movie's Poster
        String newMoviePoster = input.nextLine();

        while (validBlank(newMoviePoster,"Movie Poster"))
            newMoviePoster = input.nextLine();
        
        //add movie to the list
        Movie newMovie = new Movie(); 
        newMovie.setId(newMovieId);
        newMovie.setTitle(newMovieTitle);
        newMovie.setYear(newMovieYear);
        newMovie.setPoster(newMoviePoster);
        
        //outprint to testing
        newMovie.displayMovieRecord();

        //add to Movie List
        newMovieList.addMovie(newMovie);
    }

    /**
     * Method to convert from String to Integer
     * 
     * @param a String of input
     * @return the Integer of out
     * @throws NumberFormatException if input is a non-number format
     */
    private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
    
    /**
     * A method to delete movie from the database system
     * if there are above two movies appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void deleteMovie()
    {
        System.out.println("Delete Movie :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search Movie to delete : ===");
        System.out.println("Search Movie , please insert keyword of id:");

        String delKeyword = input.nextLine().toLowerCase();

        while (validBlank(delKeyword,"Name keyword"))
            delKeyword = input.nextLine().toLowerCase();

        ArrayList<Movie> delResultList = newMovieList.searchMovie(delKeyword);

        //display Movie details
        System.out.println("Search Result");
        for (int j = 0 ; j < delResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            delResultList.get(j).displayMovieRecord();
        }

        int size = delResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String delUserSelection = input.nextLine();
            int index = convertStringtoInt(delUserSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                delUserSelection = input.nextLine();
                index = convertStringtoInt(delUserSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(delUserSelection,"Selection"))
                {    
                    delUserSelection = input.nextLine();
                    index = convertStringtoInt(delUserSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(delUserSelection);

            String delUserName;

            if (size != 0)
                delUserName = delResultList.get(index -1).getId();
            else
                delUserName = "";

            //System.out.println("Delete User , please insert delete title:");
            //String delUserName = input.nextLine();
            newMovieList.deleteMovie(delUserName);
        }
        else
            System.out.println("No matched movies");
    }

    /**
     * A method to display Menu
     * 
     * @param
     * @return 
     */

    private void displayMenu()
    {
        //interface
        System.out.println("");
        System.out.println("=====================");
        System.out.println("(1) Search Movie");
        System.out.println("(2) Add Movie");
        System.out.println("(3) Delete Movie");
        System.out.println("(4) Edit Movie (Title, Year and Poster)");
        System.out.println("(5) Exit System");
        System.out.print("Choose an option :");
    }

    /**
     * A method to edit movie from the database system
     * if there are above two movies appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void editMovie()
    {
        System.out.println("Edit Movie :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search Movie to edit : ===");
        System.out.println("Search Movie , please insert keyword of id:");

        String editKeyword = input.nextLine().toLowerCase();

        while (validBlank(editKeyword,"Name keyword"))
            editKeyword = input.nextLine().toLowerCase();

        ArrayList<Movie> editResultList = newMovieList.searchMovie(editKeyword);

        //display User details
        System.out.println("Search Result");
        for (int j = 0 ; j < editResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            editResultList.get(j).displayMovieRecord();
        }

        int size = editResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to edit, press 0 to quit :");
            String editUserSelection = input.nextLine();
            int index = convertStringtoInt(editUserSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                editUserSelection = input.nextLine();
                index = convertStringtoInt(editUserSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(editUserSelection,"Selection"))
                {    
                    editUserSelection = input.nextLine();
                    index = convertStringtoInt(editUserSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(editUserSelection);

            String editMovieId;

            if (size != 0)
                editMovieId = editResultList.get(index - 1).getId();
            else
                editMovieId = "";

            if (size !=0)
            {
                System.out.println("==== Edit Movie ====");

                System.out.println("Please insert new title :");        
                //input newTitle
                String newTitle = input.nextLine();

                while (validBlank(newTitle,"Title"))
                    newTitle = input.nextLine();

                System.out.println("Please insert new year :");    
                //input newYear
                String newYear = input.nextLine();

                while (validSpace(newYear))
                    newYear = input.nextLine();
                    
                System.out.println("Please insert new Poster :");    
                //input newPoster
                String newPoster = input.nextLine();

                while (validSpace(newPoster))
                    newPoster = input.nextLine();

                ArrayList<String> editActorStringList = new ArrayList<String>();
                editActorStringList.add(newTitle);
                editActorStringList.add(newYear);
                editActorStringList.add(newPoster);
               
                newMovieList.editMovie(editMovieId,newTitle,newYear,newPoster);
               
            }
        }
        else
            System.out.println("No matched movies");
    }

    /**
     * A method to exit the system
     * 
     * @param
     * @return a boolean to make isOperating = false and break the while loop
     */
    private boolean exitSystem()
    {
        System.out.println("Exit System");
        //write into file
        writeFile();
        writeEventFile();

        //reset all the attributes
        newMovieList = new MovieDatabase();
        newEventList = new EventDatabase();
        
        return false;
    }

    /**
     * A method to read from file
     * 
     * @param  
     * @return
     * @throws FileNotFoundException if file is not found
     * @throws IOException while exception during I/O actions
     */
    private void readFile()
    {
        String filename = ("movies.txt");
        String staff;
        Movie loadFromFile;
        // try catch to handle FileNotFoundException and IOException
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Movie(); 
                staff = parser.nextLine();
                String[] attribute = staff.split(",");

                for (int i = 0 ; i < attribute.length ; i++)
                {
                   System.out.println (attribute[i]);
                
                   //numbers of Movies
                   //for (int k = 0 ; k < loadFromFile.getNumbersOfElements() ; k++)
                   //{
                   //attributes of Movies
                   //}
                }

                System.out.println ("Movie"+ linecount);
                loadFromFile.setId(attribute[0]);
                loadFromFile.setTitle(attribute[1]);
                loadFromFile.setYear(attribute[2]);
                loadFromFile.setPoster(attribute[3]);
                
                //add movie to the list
                Movie newMovie = new Movie();                               

                loadFromFile.displayMovieRecord();
                newMovieList.addMovie(loadFromFile);
                linecount++;
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }

    /**
     * A method to read from file
     * 
     * @param  
     * @return
     * @throws FileNotFoundException if file is not found
     * @throws IOException while exception during I/O actions
     */
    private void readEventFile()
    {
        String filename = ("events.txt");
        String eventStaff;
        Event loadFromFile;
        // try catch to handle FileNotFoundException and IOException
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Event(); 
                eventStaff = parser.nextLine();
                String[] attribute = eventStaff.split(",");

                for (int i = 0 ; i < attribute.length ; i++)
                {
                   System.out.println (attribute[i]);
                
                   //numbers of Movies
                   //for (int k = 0 ; k < loadFromFile.getNumbersOfElements() ; k++)
                   //{
                   //attributes of Movies
                   //}
                }

                System.out.println ("Movie"+ linecount);
                loadFromFile.setId(attribute[0]);
                loadFromFile.setTitle(attribute[1]);
                loadFromFile.setStartDate(attribute[2]);
                loadFromFile.setEndDate(attribute[3]);
                loadFromFile.setVenue(attribute[4]);
                loadFromFile.setLocation(attribute[5]);
                
                //add movie to the list
                Event newEvent = new Event();                               

                loadFromFile.displayEventRecord();
                newEventList.addEvent(loadFromFile);
                linecount++;
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * A method to search movie
     * 
     * @param
     * @return 
     */
    private void searchMovie() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println("=== Search Movie ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Movie , please insert a keyword to search by id:");
        String newMovieId = input.nextLine().toLowerCase();

        while(validBlank(newMovieId,"Movie Id"))
            newMovieId = input.nextLine().toLowerCase();

        //searchUser()
        ArrayList<Movie> resultList = newMovieList.searchMovie(newMovieId);

        //display User details
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displayMovieRecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
    }

    /**
     * A method to start operating the system
     * 
     * @param
     * @return 
     */
    public void start()
    {
        //Scanner
        Scanner input = new Scanner(System.in);
        Boolean isOperating = true;

        //read movie and event from file
        readFile();
        readEventFile();
        
        while (isOperating)
        {                        
            //display menu 
            displayMenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");

            //check console.nextLine() is not null or blank
            if (validBlank(iobuffer,"Option"))
            { 
                char option = iobuffer.charAt(0);

                //if option not in 1,2,3,4,5 Error message: please insert from (1) to (5)!
                if (validOption(option))
                {
                    switch (option)
                    {
                        case '1':
                        //search Movie from the list by movie id
                        searchMovie();
                        break;
                        case '2':
                        //add Movie to the list
                        addMovie();
                        break;
                        case '3':
                        //delete Movie from the list
                        deleteMovie();
                        break;
                        case '4':
                        //Edit Movie from the list (Title, Year and Poster) (HD)
                        editMovie();
                        break;
                        case '5':
                        //Exit system, and reset variables
                        isOperating = exitSystem();
                        break;
                        case '6':
                        //Exit system, and reset variables
                        System.out.println("== create an event and add into file ==");
                        break;
                        case '7':
                        //Exit system, and reset variables
                        System.out.println("== edit event and add into file ==");
                        break;
                    }
                }

                if (!isOperating)
                {
                    System.out.println("");
                    System.out.println("Thank you for using User Database System, Goodbye!");
                }
            }
        }
    }

    /**
     * Method to check insert any emptys or blank
     * 
     * @param iobuffer the iobuffer
     * @param subject the subject
     * @return the boolean of checkBlank
     */
    private boolean validBlank(String iobuffer,String subject) //method to check insert any empties or blanks
    {
        if (subject.equals("Option"))
        {
            //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (5)! and return false to break if condition
            if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from (1) to (5)!");
                return false;
            }
            return true;
        }
        else
        {    
            //iobuffer.trim().isEmpty(), "Error: subject's name shouldn't be blank! Please enter the name again:" and return true to keep while condition
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " shouldn't be blank! Please enter the name again:");
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check Delete selection is from 1 to size
     * 
     * @param index the index to be validated, the size the size
     * @return the boolean of checkDelSelection
     */
    private boolean validDelSelection(int index, int size) //method to check int index
    {
        //check if rating is from 1 to size  and return false to break while loop
        if (index < 0 || index > size)
        {
            System.out.println("Error : please insert from (1) to (" + size +")!");
            System.out.print("Please insert :");
            return true;
        }
        return false;
    }

    /**
     * Method to check Movie Id repeatation
     * 
     * @param UserName the Name
     * @return the boolean of User Name repeatation
     */
    private boolean validMovieId(String movieId) //method to check User Name repeatation
    {
        //check if movie id is not in database , and return false to break while loop
        boolean isRepeated = newMovieList.validMovieId(movieId);
        if (isRepeated)
        {
            System.out.println("Error : Movie id existed , please insert another Movie Id!");
            return isRepeated;
        }
        return false;
    }

    /**
     * Method to check char option
     * 
     * @param option the option
     * @return the boolean of checkOption
     */
    private boolean validOption(char option) //method to check char option
    {
        //check if option is in 1,2,3,4,5,6 , and return false to break if condition , 6 for (HD)
        if (option < '1' || option > '7')
        {
            System.out.println("Error : please insert from (1) to (7)!");
            return false;
        }
        return true;        
    }

    /**
     * Method to check insert any space
     * 
     * @param iobuffer the iobuffer
     * @return the boolean of checkBlank
     */
    private boolean validSpace(String iobuffer) //method to check insert any space characters only on Actor2 or Actor3
    {
        //Actor2 or Actor3.charAt(0) == ' ', "Error: subject's name shouldn't be space only! Please enter the name again:" and return true to keep while condition
        if (iobuffer.isEmpty())
            return false;
        else if (iobuffer.charAt(0) == ' ')
        {
            System.out.println("Error: Att(UserType) shouldn't be space only or start by space character! Please enter the name again:");
            return true;
        }
        return false;
    }

    /**
     * A method to write to file
     * 
     * @param  
     * @return
     * @throws IOException while exception during I/O actions
     */
    private void writeFile()
    {
        String filename = ("myMovie.txt");
        //use User.getNumbersOfElement() to replace 6
        String[] staff = new String[4];
        Scanner input = new Scanner(System.in);
        String line = "";
        int numberOfStaffs;
        MovieDatabase toWriteMovieList = new MovieDatabase();
        
        //print the result of inserting
        System.out.println("How many movies your want to insert :");
        //numberOfStaffs = convertStringtoInt(input.nextLine());
        numberOfStaffs = newMovieList.getNumbersOfMovies();
        System.out.println(numberOfStaffs + "");
        //try catch to handle IOException
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);

            for (int i = 0 ; i < numberOfStaffs ; i++ )
            {
                staff[0] = newMovieList.getMovieList().get(i).getId();
                staff[1] = newMovieList.getMovieList().get(i).getTitle();
                staff[2] = newMovieList.getMovieList().get(i).getYear();
                staff[3] = newMovieList.getMovieList().get(i).getPoster();
               
                //combine elements into a line
                for (int k = 0 ; k < 4 ; k++ )
                {   
                    //line = staff[0] + "," + staff[1] + "," + staff[2] + "," + staff[3] + "," + staff[4] + "," + staff[5];
                    if (k != 4 - 1)
                        line = line + staff[k] + ",";
                    else
                        line = line + staff[k];
                }
                //display a message about write line
                System.out.println("");
                System.out.println("Write a message in line to a file");
                System.out.println("");

                outputFile.println(line);
                //reset line
                line = "";
            }
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * A method to write to file
     * 
     * @param  
     * @return
     * @throws IOException while exception during I/O actions
     */
    private void writeEventFile()
    {
        String filename = ("myEvent.txt");
        //use Event.getNumbersOfElement() to replace 6
        String[] eventStaff = new String[6];
        Scanner input = new Scanner(System.in);
        String line = "";
        int numberOfEventStaffs;
        EventDatabase toWriteEventList = new EventDatabase();
        
        //print the result of inserting
        System.out.println("How many events your want to insert :");
        //numberOfStaffs = convertStringtoInt(input.nextLine());
        numberOfEventStaffs = newEventList.getNumbersOfEvents();
        System.out.println(numberOfEventStaffs + "");
        //try catch to handle IOException
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);

            for (int i = 0 ; i < numberOfEventStaffs ; i++ )
            {
                eventStaff[0] = newEventList.getEventList().get(i).getId();
                eventStaff[1] = newEventList.getEventList().get(i).getTitle();
                eventStaff[2] = newEventList.getEventList().get(i).getStartDate();
                eventStaff[3] = newEventList.getEventList().get(i).getEndDate();
                eventStaff[4] = newEventList.getEventList().get(i).getVenue();
                eventStaff[5] = newEventList.getEventList().get(i).getLocation();
               
                //combine elements into a line
                for (int k = 0 ; k < 6 ; k++ )
                {   
                    //line = staff[0] + "," + staff[1] + "," + staff[2] + "," + staff[3] + "," + staff[4] + "," + staff[5];
                    if (k != 6 - 1)
                        line = line + eventStaff[k] + ",";
                    else
                        line = line + eventStaff[k];
                }
                //display a message about write line
                System.out.println("");
                System.out.println("Write a message in line to a file");
                System.out.println("");

                outputFile.println(line);
                //reset line
                line = "";
            }
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}