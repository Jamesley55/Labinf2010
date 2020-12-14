package KthSmallestElement;

import java.util.ArrayList;

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

        return null;
    }

}

 class Pixel implements Comparable{
    int x;
    int y;
    Comparable value;

    public Pixel(int x, int y, Comparable value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof Pixel)) {
            throw new IllegalArgumentException("Object o is not of type Pixel");
        }
        Pixel pixel = (Pixel) object;
        if(this.value == null )
            return -1;
        if(pixel.value == null )
            return 1;
        return pixel.value.compareTo(this.value);
    }

}

