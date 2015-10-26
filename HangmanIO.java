import java.util.*;

public class HangmanIO{
     
     
     //Ask for user input
     public char userInput(){
          Scanner input = new Scanner(System.in);
          char letter = ' ';
          System.out.println("Guess a letter: ");
          letter = input.nextLine().charAt(0); //store only first letter from the user input
          return letter;
     }
     
     //ask user if wants to play again
     public char again(char cont){
          Scanner input = new Scanner(System.in);
          System.out.println("Try again? (Y/y)");
          cont = input.nextLine().charAt(0);
          return cont;
     }
     
     //prints game over message and the guessing word
     public void gameOver(String guessingWord){
          System.out.println("Game Over!");
          System.out.println("The word is " + guessingWord + ".");
     }
     
     //prints output for winning the game
     public void correct(){
          System.out.println("You won!");
     }
}