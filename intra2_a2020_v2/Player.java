

import java.util.ArrayList;
import java.util.Collection;

public class Player {
   
   String letters;
   static ODS dictionnaire = new ODS();
   static Scrabble jeu = new Scrabble(); 
   
   public Player(String str) {
      letters = str;
   }
   
   public Collection<String> getCombinations(boolean useHashTable){
      
      Collection<String> combinations;
      
      if( !useHashTable ) 
         combinations = new ArrayList<String>();
      else 
         combinations = new QuadraticProbingHashTable<String>();
      
      if( letters == null)
         return combinations;
      
      combinations.addAll( Util.getAllCombinations( letters ) ); 
      
      return combinations;
   }
}
