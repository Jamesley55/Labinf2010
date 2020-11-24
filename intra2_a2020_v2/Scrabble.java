

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Scrabble {
   
   List<Character> availableLetters;
   
   private static int alphabetSize  = 26;
   private static Map<Character, Integer> letterValues;
   
   private static int[][] NB_LETTERS = {
         {'A',  9},
         {'B',  2},
         {'C',  2},
         {'D',  3},
         {'E', 15},
         {'F',  2},
         {'G',  2},
         {'H',  2},
         {'I',  8},
         {'J',  1},
         {'K',  1},
         {'L',  5},
         {'M',  3},
         {'N',  6},
         {'O',  6},
         {'P',  2},
         {'Q',  1},
         {'R',  6},
         {'S',  6},
         {'T',  6},
         {'U',  6},
         {'V',  2},
         {'W',  1},
         {'X',  1},
         {'Y',  1},
         {'Z',  1}};
   
   private static int[][] LETTRE_VALUES = {
         {'A',  1},
         {'B',  3},
         {'C',  3},
         {'D',  2},
         {'E',  1},
         {'F',  4},
         {'G',  2},
         {'H',  4},
         {'I',  1},
         {'J',  8},
         {'K', 10},
         {'L',  1},
         {'M',  2},
         {'N',  1},
         {'O',  1},
         {'P',  3},
         {'Q',  8},
         {'R',  1},
         {'S',  1},
         {'T',  1},
         {'U',  1},
         {'V',  4},
         {'W', 10},
         {'X', 10},
         {'Y', 10},
         {'Z', 10}};
   
   public Scrabble(){
      
      availableLetters = new LinkedList<Character>();
      
      for(int i=0; i<alphabetSize; i++) {
         for(int j=0; j<NB_LETTERS[i][1]; j++)
            availableLetters.add( (char)NB_LETTERS[i][0] );
      }
      
      letterValues = new HashMap<Character, Integer>();

      for(int i=0; i<alphabetSize; i++) 
         letterValues.put( (char)LETTRE_VALUES[i][0], LETTRE_VALUES[i][1]);
   } 
   
   public List<Character> getLetters(int nbLetters){
      Util.shuffleLetters(availableLetters);
      List<Character> lc = new ArrayList<Character>();
      
      int i = 0;
      while( i++ < nbLetters && !availableLetters.isEmpty() )
         lc.add(availableLetters.remove(availableLetters.size()-1));
      
      return lc;
   }
   
   public int evaluate(List<Character> myLetters) {
      int total = 0;
      for(Character c : myLetters) {
         if( letterValues.containsKey(c) )
            total += letterValues.get(c);
      }
      return total;
   }
}
