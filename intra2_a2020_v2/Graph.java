

import java.util.HashSet;

public interface Graph {
   void initialize(int V);
   int V(); // cardinal de l’ensemble des sommets
   int E(); // cardinal de l’ensemble des arcs
   void connect(int v1, int v2);
   HashSet<Integer> adj(int v); // liste d’adjacence
   String toString();
}
