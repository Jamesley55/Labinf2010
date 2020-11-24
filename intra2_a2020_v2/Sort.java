

public final class Sort
{
   /**
    * Simple insertion sort.
    * @param a an array of Comparable items.
    */
   public static <AnyType extends Comparable<? super AnyType>>
   void insertionSort( AnyType [ ] a )
   {
      int j;

      for( int p = 1; p < a.length; p++ )
      {
         AnyType tmp = a[ p ];
         for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
            a[ j ] = a[ j - 1 ];
         a[ j ] = tmp;
      }
   }

   /**
    * Mergesort algorithm.
    * @param a an array of Comparable items.
    */
   public static <AnyType extends Comparable<? super AnyType>>
   void mergeSort( AnyType [ ] a )
   {
      @SuppressWarnings("unchecked")
      AnyType [ ] tmpArray = (AnyType[]) new Comparable[ a.length ];

      mergeSort( a, tmpArray, 0, a.length - 1 );
   }

   /**
    * Quicksort algorithm.
    * @param a an array of Comparable items.
    */
   public static <AnyType extends Comparable<? super AnyType>>
   void quickSort( AnyType [ ] a )
   {
      quickSort( a, 0, a.length - 1 );
   }

   /**
    * Internal method that makes recursive calls.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param left the left-most index of the subarray.
    * @param right the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray,
         int left, int right )
   {
      if( left < right )
      {
         int center = ( left + right ) / 2;
         mergeSort( a, tmpArray, left, center );
         mergeSort( a, tmpArray, center + 1, right );
         merge( a, tmpArray, left, center + 1, right );
      }
   }

   /**
    * Internal method that merges two sorted halves of a subarray.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param leftPos the left-most index of the subarray.
    * @param rightPos the index of the start of the second half.
    * @param rightEnd the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void merge( AnyType [ ] a, AnyType [ ] tmpArray, int leftPos, int rightPos, int rightEnd )
   {
      int leftEnd = rightPos - 1;
      int tmpPos = leftPos;
      int numElements = rightEnd - leftPos + 1;

      // Main loop
      while( leftPos <= leftEnd && rightPos <= rightEnd )
         if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
         else
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];

      while( leftPos <= leftEnd )    // Copy rest of first half
         tmpArray[ tmpPos++ ] = a[ leftPos++ ];

      while( rightPos <= rightEnd )  // Copy rest of right half
         tmpArray[ tmpPos++ ] = a[ rightPos++ ];

      // Copy tmpArray back
      for( int i = 0; i < numElements; i++, rightEnd-- )
         a[ rightEnd ] = tmpArray[ rightEnd ];
   }

   private static final int CUTOFF = 3;

   /**
    * Method to swap to elements in an array.
    * @param a an array of objects.
    * @param index1 the index of the first object.
    * @param index2 the index of the second object.
    */
   public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
   {
      AnyType tmp = a[ index1 ];
      a[ index1 ] = a[ index2 ];
      a[ index2 ] = tmp;
   }

   /**
    * Return median of left, center, and right.
    * Order these and hide the pivot.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   AnyType median3( AnyType [ ] a, int left, int right )
   {
      int center = ( left + right ) / 2;
      if( a[ center ].compareTo( a[ left ] ) < 0 )
         swapReferences( a, left, center );
      if( a[ right ].compareTo( a[ left ] ) < 0 )
         swapReferences( a, left, right );
      if( a[ right ].compareTo( a[ center ] ) < 0 )
         swapReferences( a, center, right );

      // Place pivot at position right - 1
      swapReferences( a, center, right - 1 );
      return a[ right - 1 ];
   }

   /**
    * Internal quicksort method that makes recursive calls.
    * Uses median-of-three partitioning and a cutoff of 10.
    * @param a an array of Comparable items.
    * @param left the left-most index of the subarray.
    * @param right the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void quickSort( AnyType [ ] a, int left, int right )
   {
      if( left + CUTOFF <= right )
      {
         AnyType pivot = median3( a, left, right );

         // Begin partitioning
         int i = left, j = right - 1;
         for( ; ; )
         {
            while( a[ ++i ].compareTo( pivot ) < 0 ) { }
            while( a[ --j ].compareTo( pivot ) > 0 ) { }
            if( i < j )
               swapReferences( a, i, j );
            else
               break;
         }

         swapReferences( a, i, right - 1 );   // Restore pivot

         quickSort( a, left, i - 1 );    // Sort small elements
         quickSort( a, i + 1, right );   // Sort large elements
      }
      else  // Do an insertion sort on the subarray
         insertionSort( a, left, right );
   }

   /**
    * Internal insertion sort routine for subarrays
    * that is used by quicksort.
    * @param a an array of Comparable items.
    * @param left the left-most index of the subarray.
    * @param right the right-most index of the subarray.
    */
   private static <AnyType extends Comparable<? super AnyType>>
   void insertionSort( AnyType [ ] a, int left, int right )
   {
      for( int p = left + 1; p <= right; p++ )
      {
         AnyType tmp = a[ p ];
         int j;

         for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
            a[ j ] = a[ j - 1 ];
         a[ j ] = tmp;
      }
   }
}
