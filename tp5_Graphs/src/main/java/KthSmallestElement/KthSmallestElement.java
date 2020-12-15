package KthSmallestElement;
import java.util.PriorityQueue;

public class KthSmallestElement {
    /**
     * Explication de votre complexité temporelle
     *
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


       if(matrix == null || k > matrix.length*matrix[0].length-1){
           return null;
       }

      /* Node[] heap = new Node[matrix.length];
       for(int row =0; row <matrix.length;row++){
           heap[row] = new Node(0,row,matrix[row][0]);
       }
       return null;

       */

        int ke = k+1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer((Integer) matrix[i][j]);
            }
        }
        while (--ke > 0) {
            pq.poll();
        }
        return (T) pq.peek();



       /*  PriorityQueue<Node>pq=new PriorityQueue<>();
        int n=matrix.length;
        for(int i=0;i<n;i++)
            pq.add(new Node(0, i, (Integer) matrix[0][i]));

        Node node = new Node(0,0, null);


        for(int j=1;j<k;j++)
        {
            node =pq.poll();
            T nextValue = node.row < matrix.length - 1 ?
                    matrix[node.collum+1][node.row] : null;


            pq.add(new Node(node.collum+1, node.row, nextValue));
        }

        return (T) pq.poll().value;

        */
    }



    static void swap(int i, int min, Node[] arr)
    {
        Node temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    static void heapify(Node[] heap, int index){
        int RightChild = 2*index +2;
        int leftChild = 2*index +1;

    }
}





 class Node implements Comparable{
    int collum;
    int row;
    Comparable value;

    public Node(int collum, int row, Comparable value){
        this.collum = collum;
        this.row = row;
        this.value = value;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof Node)) {
            throw new IllegalArgumentException("Object o is not of type Pixel");
        }
        Node node = (Node) object;
        if(this.value == null )
            return -1;
        if(node.value == null )
            return 1;
        return node.value.compareTo(this.value);
    }

}

