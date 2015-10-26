public class HangmanProcess{
     
     //Check for a word
     public boolean check(String word, char letter){
          boolean result = false;
          for(int i = 0; i < word.length(); i++){
               if(word.charAt(i) == letter){
                    result = true;
               }
          }
          return result;
     }
     
     //Return the number of letter in the guessing word
     public int numLetterPosition(String word, char letter){
          int count = 0;
          for(int i = 0; i < word.length(); i++){
               if(word.charAt(i) == letter){
                    count++;
               }
          }
          return count;
     }
     
     //Store the position of the letter from the guessing word
     public int[] letterPosition(String word, char letter, int numLetter){
          int[] position = new int[numLetter];
          int j = 0;
          for(int i = 0; i < word.length(); i++){
               if(word.charAt(i) == letter){
                    position[j++] = i * 2; // i * 2 becuase each letter is sperated by 1 space
               }
          }
          return position;
     }
     
     
     //Reveal the letter from the user input
     public char[] progress(boolean result, char[] word, char letter, int[] position){
          if(result == true){
               int pos = 0;
               for(int i = 0; i < position.length; i++){
                    pos = position[i];
                    word[pos] = letter;
               }
          }
          return word;
     }
     
     //Check whether the game is finished or not
     public boolean isFinish(char[] word){
          boolean result = true;
          for(int i = 0; i < word.length; i++){
               if(word[i] =='_'){
                    result = false;
               }
          }
          return result;
     }
     
     //Giving user 10 chances to guess
     public int lives(int life, boolean check){
          if(check == false){   
               life--;
          }
          if(life > 1){
               System.out.println("You have " + life + " lives");  
          }
          else if(life == 1){
               System.out.println("You have " + life + " life");
          }        
          return life;
     }
}