
import java.security.InvalidParameterException;
import java.util.LinkedList;

public class CFC {
   
   private void findCfc(DirectedGraph G) {
      findOrder(G);

      for( int v : dfo ) {

         if( !marked[v] ){
            secondDfs(v, G);
            count++;
         }
      }
   }
   
   private boolean[]   dfsMarked;
   private boolean[]   marked;
   private int[]       id;
   private int         count;
   LinkedList<Integer> dfo;

   public CFC(DirectedGraph G){
      
      if(G == null) 
         throw new InvalidParameterException();

      dfsMarked = new boolean[G.V()];
      marked    = new boolean[G.V()]; 
      id        = new int[G.V()];
      count     = 1;
      dfo       = new LinkedList<Integer>();
      
      findCfc(G);
      
   }
   
   public int nbCfc() {
      return count;
   }
   
   private void findOrder(DirectedGraph G) {

      DirectedGraph  GT   = G.transposed();            
      
      for(int s=0; s<GT.V(); s++)
         if( !dfsMarked[s] )
            firstDfs1(s, GT);
   }
   
   private void firstDfs1(int s, DirectedGraph G){
      dfsMarked[s] = true;
      
      for(int w : G.adj(s))
         if( !dfsMarked[w] )
            firstDfs1(w, G);
      
      dfo.addFirst(s);
   }

   private void secondDfs(int v, Graph G){
      marked[v] = true;
      id[v] = count;

      for(int w : G.adj(v))
         if(!marked[w])
            secondDfs(w, G);
   }
   
   public int[] getID() {
      int[] rID = new int[id.length]; 
      System.arraycopy(id, 0, rID, 0, id.length);
      return rID;
   }
}
