import java.io.*;
import java.util.*;

public class HangmanWord{
     
     //wordCount opens file and counts the number of words in a text file
     public int wordCount(String fileName){
          BufferedReader br = null;
          int count = 0;
          try{
               br = new BufferedReader(new FileReader(fileName));
               String line = br.readLine();
               
               while(line != null){
                    line = br.readLine();
                    count++;
               }
          }
          catch(IOException e){
               e.printStackTrace();
          }
          finally{
               try {
                    if (br != null)br.close();
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
          return count;
     }
     
     //get the guessing word from index(from random generator)
     public String getWord(String fileName, int index){
          BufferedReader br = null;
          String line = null;
          try{
               br = new BufferedReader(new FileReader(fileName));
               StringBuilder sb = new StringBuilder();               
               for(int i = 0; i < index; i++){
                    line = br.readLine();
               }
          }
          catch(IOException e){
               e.printStackTrace();
          }
          finally{
               try {
                    if (br != null)br.close();
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
          return line;
     }
     //Generate random index
     public int randomNumber(int length){
          Random randomGenerator = new Random();
          int random = randomGenerator.nextInt(length) - 1;
          return random;
     }
     
     //Get the length of guessing word
     public int wordLength(String word){
          int length = 0;
          length = word.length();
          return length;
     }
     
     //initialize the array with _ and space for better look
     public char[] initialWordArray(int length){
          char[] word = new char[length * 2];
          for(int i = 0; i < length * 2; i = i + 2){
               word[i] = '_';
               word[i + 1] = ' ';
          }
          return word;
     }
}