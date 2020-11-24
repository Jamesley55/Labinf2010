/**
 * Cette classe reprend le code de Weiss du BinaryHeap 
 * et le modifie pour ajouter l'option d'avoir un monceau max
 */

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
   /**
    * Construct the binary heap.
    */
   public BinaryHeap( )
   {
      this( DEFAULT_CAPACITY );
   }

   /**
    * Construct the binary heap.
    * @param capacity the capacity of the binary heap.
    */
   @SuppressWarnings("unchecked")
   public BinaryHeap( int capacity )
   {
      currentSize = 0;
      isMinHeap   = true;
      array = (AnyType[]) new Comparable[ capacity + 1 ];
   }

   /**
    * Construct the binary heap given an array of items.
    */
   public BinaryHeap( AnyType [ ] items ){
      this(items, true);
   }

   /**
    * Construct the binary heap given an array of items.
    */
   @SuppressWarnings("unchecked")
   public BinaryHeap( AnyType [ ] items, boolean isMinHeap )
   {
      this.currentSize = items.length;
      this.isMinHeap   = isMinHeap;
      array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

      int i = 1;
      for( AnyType item : items )
         array[ i++ ] = item;
      buildHeap();
   }

   /**
    * Insert into the priority queue, maintaining heap order.
    * Duplicates are allowed.
    * @param x the item to insert.
    */
   public void insert( AnyType x )
   {
      if( currentSize == array.length - 1 )
         enlargeArray( array.length * 2 + 1 );

      // Percolate up
      int hole = ++currentSize;
      for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
         array[ hole ] = array[ hole / 2 ];
      array[ hole ] = x;
   }


   @SuppressWarnings("unchecked")
   private void enlargeArray( int newSize )
   {
      AnyType [] old = array;
      array = (AnyType []) new Comparable[ newSize ];
      for( int i = 0; i < old.length; i++ )
         array[ i ] = old[ i ];        
   }

   /**
    * Find the smallest item in the priority queue.
    * @return the smallest item, or throw an UnderflowException if empty.
    */
   public AnyType findMin( )
   {
      if( isEmpty( ) )
         throw new UnderflowException( );
      return array[ 1 ];
   }

   /**
    * Remove the root item from the priority queue.
    * @return the root item, or throw an UnderflowException if empty.
    */
   public AnyType deleteRoot( )
   {
      if( isEmpty( ) )
         throw new UnderflowException( );

      AnyType minItem = findMin( );
      array[ 1 ] = array[ currentSize-- ];
      percolateDown( 1 );

      return minItem;
   }

   /**
    * Establish heap order property from an arbitrary
    * arrangement of items. Runs in linear time.
    */
   private void buildHeap( )
   {
      for( int i = currentSize / 2; i > 0; i-- )
         percolateDown( i );
   }

   /**
    * Test if the priority queue is logically empty.
    * @return true if empty, false otherwise.
    */
   public boolean isEmpty( )
   {
      return currentSize == 0;
   }

   /**
    * Make the priority queue logically empty.
    */
   public void makeEmpty( )
   {
      currentSize = 0;
   }

   private static final int DEFAULT_CAPACITY = 10;

   private int currentSize;      // Number of elements in heap
   private AnyType [ ] array; // The heap array
   private boolean isMinHeap;

   /**
    * Internal method to percolate down in the heap.
    * @param hole the index at which the percolate begins.
    */
   private void percolateDown( int hole ){
      int child;
      AnyType tmp = array[ hole ];

      for( ; hole * 2 <= currentSize; hole = child ) {
         child = hole * 2;
         if( child != currentSize &&
             array[ child + 1 ].compareTo( array[ child ] ) > 0 )
            child++;
         if( array[ child ].compareTo( tmp ) > 0 )
            array[ hole ] = array[ child ];
         else
            break;
      }
      array[ hole ] = tmp;
   }
}