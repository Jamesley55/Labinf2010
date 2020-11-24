

public class Word implements Comparable<Word>{
   String string;
   int value;
   
   public Word(){
      string  = new String();
      value = 0;
   }
   
   Word(String word, int value){
      this.string  = word;
      this.value = value;
   }

   @Override
   public int compareTo(Word w) {
      return value - w.value;
   }
   
   @Override
   public int hashCode() {
      return string.hashCode();
   }
   
   public String getString() {
      return string;
   }
   
   public int getValue() {
      return value;
   }
   
   public String toString() {
      return "Mot:\t" + string + "\tValeur:\t" + value;
   }
}
