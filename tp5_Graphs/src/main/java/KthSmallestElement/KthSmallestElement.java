package KthSmallestElement;
import java.util.PriorityQueue;

public class KthSmallestElement {
    /**
     * Explication de votre complexité temporelle
     * tout d'abord, nous avons mis tout les elements de la premiere colonne de la matrice dans un priorityQueue
     * le PriorityQueue a une complexite temporelle log(n) pour l'appelle a la fonction "add"
     * le "for loop" sur la premiere colonne et la fonction "add" du PriorityQueue
     * nous donne une complexite temporelle O(cLog(c)).
     *
     * Explication de votre complexité spatiale
     *
     *
     */
    /** TODO Worst case
     *      Time complexity : O ( k log max(m,n) )
     *      Space complexity : O ( max(m,n) )
     *
     * Returns the `k`th smallest element in `matrix`
     * @param matrix 2D table of shape M x N respecting the following rules
     *               matrix[i][j] <= matrix[i+1][j]
     *               matrix[i][j] <= matrix[i][j + 1]
     * @param k Index of the smallest element we want
     * @return `K`th smallest element in `matrix`, null if non-existent
     */
    static public <T extends Comparable<T>> T findKthSmallestElement(final T[][] matrix, final int k) {
       // c = column , r = row
       // Matrix c*r
       if(matrix == null || k > matrix.length*matrix[0].length-1 || k <0){
           return null;
       }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 0(c*log(c))
        for(int i =0; i< matrix.length; i++){
           pq.add(new Node(0,i, (Integer) matrix[i][0]));
       }

        // O(k*log(c))
        for(int i=0; i<k; i++){

            // enleve la plus petite valeur
            // et on le met dans une variable temporaire
            // O(log(c))
            Node headNode = pq.poll();

            // quand il y a une valeur a gauche
            // on le rajoute dans le pq
            if(headNode.x < matrix[headNode.y].length-1){
                // O(log(c+1))
                pq.add(new Node(headNode.x+1, headNode.y, (Integer) matrix[headNode.y][headNode.x+1]));
            }
            // complexite temporelle max total
            // O(c*log(c))+ O(k*log(c))
            // O((c+k)log(c))

        }
        return (T) pq.poll().value;

    }


}





 class Node implements Comparable{
    int x;
    int y;
    Integer value;

    public Node(int x, int y, Integer value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof Node)) {
            throw new IllegalArgumentException("Object o is not of type Node");
        }
         return this.value - ((Node) object).value;
    }

}

