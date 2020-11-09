public class Interview<ValueType extends Comparable<? super ValueType>> {
    // 2D array of any shape which contains elements sorted from left to right, top to bottom
    private final ValueType[][] matrix;

    public Interview(ValueType[][] matrix) {
        this.matrix = matrix.clone();
    }

    /**
     * TODO Worst case : O ( max(log n, log m) )
     * <p>
     * Verifies if the value is contained within the 2D array
     *
     * @param value value to verify
     * @return if value is in matrix
     */
    public boolean contains(ValueType value) {
        int height = matrix[0].length ;
        int width = matrix.length ;
        int n;
        if (width > height) {
            n = width;
        } else {
            n = height;
        }
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j].compareTo(value) == 0) {
                return true;
            }
            if (matrix[i][j].compareTo(value) > 0)
                j--;
            else
                i++;
        }

        return false;
    }
}
