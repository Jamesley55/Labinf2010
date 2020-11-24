

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ODS {

   String fileName = "ods.txt"; // <= Donnez le chemin vers le fichier
   
   QuadraticProbingHashTable<String> hashTable;
   
   public ODS() {
      
      hashTable = new QuadraticProbingHashTable<String>();
      
      try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
         hashTable.addAll( br.lines().collect(Collectors.toList()) );
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public boolean contains(String str) {
      return hashTable.contains(str);
   }
}
