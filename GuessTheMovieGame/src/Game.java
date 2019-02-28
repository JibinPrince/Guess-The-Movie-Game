import java.util.Scanner;               // Import Scanner class
import java.util.Arrays;                // Import Arrays class

// Game class
public class Game {
    // Fields
    String title;

    // Default constructor
    public Game(){
        title = "";
    }

    // Parameterized constructor
    public Game(String movieTitle){
        this.title = movieTitle;
    }

    // Method that handles user guesses and controls game mechanics
    public void dashedMovieTitle(String randomTitle){
        Scanner guess = new Scanner(System.in);                                 // Create a Scanner object
        String dashes = randomTitle.replaceAll("\\S", "-");    // Replace random movie title with dashes
        char [] titleArray = dashes.toCharArray();                              // Turn String dashed title into character array of title's letters
        String wrongGuesses = "";                                               // Tracks wrongly guessed letters
        int wrong = 0;                                                          // Variable that tracks number of wrong guesses
        char [] randomArray = randomTitle.toCharArray();                        // Turn String title into character array of title's letters
        System.out.print("You are guessing: ");
        System.out.println(dashes);                                             // Print dashed title

        // Guessing mechanics
        while(wrong < 10){
            // Requests user input (one letter)
            System.out.print("Guess a letter: ");
            char let = guess.next().charAt(0);
            // If guessed letter is in the title, appropriate dash(es) is/are replaced with guessed letter
            // If guessed letter is not in the title, wrong variable is incremented and guessed letter is added
                // in the wrongGuesses variable
            if(randomTitle.indexOf(let) != -1){
                for(int i = 0; i < titleArray.length; i++){
                    if(randomTitle.charAt(i) == let){
                        titleArray[i] = let;
                    }
                }
                // If no dashed lines remains, display congratulations to the user and end program
                if(Arrays.equals(randomArray, titleArray)){
                    System.out.println("You win!");
                    System.out.println("You have guessed '" + randomTitle + "' correctly.");
                    break;
                }
            }
            else{
                wrong++;
                wrongGuesses += let + " ";
            }
            System.out.print("You are guessing: ");
            System.out.println(titleArray);
            System.out.println("You have guessed (" + wrong + ") wrong letters: " + wrongGuesses);
        }
    }


}
