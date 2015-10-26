import java.util.*;
import java.io.*;

public class HangmanGame{
     public void game(){
          
          HangmanIO hIO = new HangmanIO();
          HangmanWord hW = new HangmanWord();
          HangmanProcess hP = new HangmanProcess();
          String fileName = "Dictionary.txt";
          int wc = 0;
          int random = 0;
          String guessWord = "";
          int length = 0;
          char[] word = new char[0];
          boolean finish = false;
          
          int life = 0;
          char again = 'y';
          int run = 0;
          do{
               if(run == 0){
                    wc = hW.wordCount(fileName);
                    random = hW.randomNumber(wc);
                    guessWord = hW.getWord(fileName, random);
                    length = hW.wordLength(guessWord);
                    
                    //System.out.println(guessWord); // Prints the guessing word
                    word = hW.initialWordArray(length);
                    
                    finish = hP.isFinish(word);
                    life = 10;
                    System.out.println("You have " + life + " lives"); 
                    System.out.println(word);
               }
               char letter = hIO.userInput();
               int numP = hP.numLetterPosition(guessWord, letter);
               
               int[] lPosition = hP.letterPosition(guessWord, letter, numP);
               boolean check = hP.check(guessWord, letter);
               
               word = hP.progress(check, word, letter, lPosition);
               System.out.println(word);
               finish = hP.isFinish(word);
               life = hP.lives(life, check);
               if(finish == false && life != 0){
                    
                    run++;
               }
               else if(finish == false && life == 0){
                    hIO.gameOver(guessWord);
                    again = hIO.again(again);
                    run = 0;
               }
               else if(finish == true && life != 0){
                    hIO.correct();
                    again = hIO.again(again);
                    run = 0;
               }
          }while((finish == false && life != 0) || (again == 'y' || again == 'Y'));
     }
}