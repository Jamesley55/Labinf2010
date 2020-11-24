

import java.util.ArrayList;
import java.util.List;

public class Intra2A2020 {
   
   public static void main(String args[]) {
      
      boolean partie2 = true;      // <= Mettre à true pour la partie 2
      boolean partie3 = false;      // <= Mettre à true pour la partie 3  
      
      /**
       * Partie 1
       */
      Scrabble jeu = new Scrabble(); 
      
      List<Character> lettres;
      
      lettres = jeu.getLetters( 7 );
      
      // Il est possible d'utiliser les lignes ci-apres pour deverminer la partie 3 
      /*
      lettres = new ArrayList<Character>();
      lettres.add('A');
      lettres.add('B');
      lettres.add('C');
      System.out.println( "Voici les lettres tirées " + lettres );/**/
      
      ODS dictionnaire = new ODS();
      
      String str = Util.toString(lettres);
      
      List<Word> combinations = new ArrayList<Word>();
      
      Player joueur = new Player(str);     

      for(String comb : joueur.getCombinations(true)) {
         
         if( dictionnaire.contains( comb ) ) {  
            Word word = new Word(comb, jeu.evaluate( Util.toList(comb) ));            
            combinations.add(word);
         }
      }
      
      Word[] array = new Word[combinations.size()];
      int i = 0;
      for(Word word : combinations)
         array[i++] = word;
      
      Sort.quickSort(array);
      
      
      BinaryHeap<Word> heap = new BinaryHeap<Word>(array, false);
      
      if( !partie2 && !partie3) {

         System.out.println( "Voici les 7 lettres tirées " + lettres );
         if( array.length < 4 ) {
            System.out.println( "Ces lettres n'offrent pas suffisamment de combinaisons." );
            System.out.println( "Essayez de changer le matricule." );
            System.out.println( "Pensez a le mentionner dans votre copie d'examen." );
         }
         else {
            System.out.println( "Meilleur choix trouvé par tri" );
            System.out.println( array[array.length-1] );
            System.out.println( "Meilleur choix trouvé par le monceau" );
            System.out.println( heap.deleteRoot() );
         }
      }
      
      /**
       * Partie 2
       */
      
      if( !partie2 )
         return;
      
      AvlTree<Word> t = new AvlTree<Word>();
      int nbElements = 0;
      for(Word w : array) {
         t.insert(w);
         nbElements++;
      }
      
      if( !partie3) {
         System.out.println( "Nombre d'elements inseres: " + nbElements );
         System.out.println( "\nArbre AVL obtenu:\n" );
         System.out.println( t.printFancyTree() );
      }
      
      /**
       * Partie 3
       */
      
      if( !partie3 )
         return;
      
      DirectedGraph g = new DirectedGraph(array.length);
      
      System.out.println( "Les éléments du graphe: " + nbElements );
      
      for(int src=0; src<array.length; src++){
         String s1 = array[src].string;
         System.out.println(src + ": " + s1);
         for(int dst=0; dst<array.length; dst++){
            if( src != dst ) {
               String s2 = array[dst].string;
               if( Util.isSubsequence(s1, s2) ) {
                  g.connect(src, dst);
               }
            }
         }
      }
      
      System.out.println( "\nLe graphe" );
      System.out.println(g);
      
      TopologicalOrder to = new TopologicalOrder(g);

      if( to.admitsOrder() ) {
         System.out.println("Le graphe admet un ordre topologique.");
      }
      else {
         System.out.println("Le graphe n'admet pas d'ordre topologique.");
      }
      
      CFC cfc = new CFC(g);
      System.out.println("Le graphe possède " + cfc.nbCfc() + " composantes fortement connexes.");
   }
}
