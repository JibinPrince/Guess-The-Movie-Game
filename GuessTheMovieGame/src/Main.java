import java.util.Scanner;       // Import Scanner class
import java.io.FileNotFoundException;
import java.io.File;            // Import File class

// Main class
public class Main {
    // Main method
    public static void main(String [] args) throws FileNotFoundException{
        // Variables
        int movieCount = 0;
        int randomMovieNum = 0;
        String movieTitle = "";

        // Read given movie list file
        File movieFile = new File("movies.txt");                 // Access file containing list of movies
        Scanner movieScan = new Scanner(movieFile);              // Reads the file
        while(movieScan.hasNextLine()){
            String line = movieScan.nextLine();
            movieCount++;                                        // Count number of movie titles in file
        }

        // Get random movie number from number of movies in text file
        randomMovieNum = (int)((Math.random() * movieCount) + 1);

        // Get (randomMovieNum)th movie title       (Ex: if rand = 15, then get 15th movie title in text file)
        File rMovieFile = new File("movies.txt");               // Access file containing list of movies
        Scanner rMovieScan = new Scanner(rMovieFile);           // Reads the file
        for(int i = 0; i < randomMovieNum; i++){
            movieTitle = rMovieScan.nextLine();
        }
        //System.out.println(movieTitle);
        System.out.println();

        // Output commentary
        System.out.println("This is Guess the Movie Game!!!!");

        Game attempt1 = new Game();                             // Declare new Game object
        attempt1.dashedMovieTitle(movieTitle);                  // Start guessing game by calling Game class with random movie title

    }
}
