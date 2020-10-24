package tp2;

import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Iterator;

public class HashMap<KeyType, DataType> implements Iterable<KeyType> {

    private static final int DEFAULT_CAPACITY = 20;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int size = 0;
    private int capacity;
    private final float loadFactor; // Compression factor

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY,
                DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        capacity = initialCapacity;
        this.loadFactor = 1 / loadFactor;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * This is the hashing function ("Fonction de dispersement")
     *
     * @param key Value used to access to a particular instance of a DataType within map
     * @return Index value where this key should be placed in attribute map
     */
    private int hash(KeyType key) {
        int keyHash = key.hashCode() % capacity;
        return Math.abs(keyHash);
    }

    /**
     * @return if map should be rehashed
     */
    private boolean needRehash() {
        return size * loadFactor > capacity;
    }

    /**
     * @return Number of elements currently in the map
     */
    public int size() {
        return size;
    }

    /**
     * @return Current reserved space for the map
     */
    public int capacity() {
        return capacity;
    }

    /**
     * @return if map does not contain any element
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * TODO Average Case : O(1)
     * Find the next prime after increasing the capacity by CAPACITY_INCREASE_FACTOR (multiplication)
     */

    // O(n)
    int nextPrime(int capacity) {
        if(capacity%2 ==0){
            capacity++;
        }
        for( ; !isPrime(capacity); capacity+=2)
            ;
        return capacity;
    }
    boolean isPrime(int n) {
        if(n ==2 || n ==3){
            return true;
        }
        if( n ==1 || n%2 ==0){
            return false;
        }
        for(int i =3; i*i <=n; i+=2)
            if(n%i ==0)
                return false;

        return true;
    }

    private void increaseCapacity() {

        capacity= nextPrime(capacity*CAPACITY_INCREASE_FACTOR);
    }

    /**
     * TODO Average Case : O(n)
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        // O(N)
        increaseCapacity();
        Node<KeyType, DataType>[] newMap = new Node[capacity];

        // O(N)
        for (int i = 0; i < map.length; i++) {
            Node<KeyType, DataType> currentNode = map[i];
            while (currentNode != null) {
                if(newMap[hash(currentNode.key)] == null){
                    newMap[hash(currentNode.key)] = new Node<KeyType,DataType>(currentNode.key,currentNode.data);
                }else{
                    newMap[hash(currentNode.key)].next = new Node<KeyType,DataType>(currentNode.key,currentNode.data);
                }
                currentNode = currentNode.next;
            }
        }

        /* this function does not work
        for (int i = 0; i < map.length; i++){
            map[i] = newMap[i];
        }
         */
        // change map  to Not Final variable in order to clone newMap inside of map
        this.map = newMap.clone();

    }

    /**
     * TODO Average Case : O(1)
     * Finds if map contains a key
     *
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {

        int index = hash(key);
        Node<KeyType,DataType> node = map[index];
        while (node !=null){
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }

         return false;
    }

    /**
     * TODO Average Case : O(1)
     * Finds the value attached to a key
     *
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        int index = hash(key);
        Node<KeyType, DataType> node = map[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * TODO Average Case : O(1) , Worst case : O(n)
     * Assigns a value to a key
     *
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        int index = hash(key);
        boolean KeyExist = containsKey(key);
        if(KeyExist){
            DataType oldData = get(key);
            map[index].data = value;
            return oldData;
        } else{
            if(map[index]== null){
                map[index] = new Node<KeyType, DataType>(key, value);
                size++;
                if(needRehash()){
                    rehash();
                }
            }
            else {
                Node<KeyType,DataType> node=map[index];
                while(node.next!=null) {
                    node = node.next;
                }
                node.next = new Node<KeyType, DataType>(key, value);
            }
        }


        return null;
    }

    /**
     * TODO Average Case : O(1)
     * Removes the node attached to a key
     *
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {

        if (containsKey(key)) {
            Node<KeyType, DataType> node = map[hash(key)];
           while(!node.key.equals(key)){
               node = node.next;
           }
            DataType oldData = node.data;
            size--;
            node = node.next;
            return  oldData;
        }
        return null;
    }

    /**
     * TODO Worst Case : O(1)
     * Removes all nodes contained within the map
     */
    public void clear() {
        map =  new Node[capacity];
        size =0;
    }

    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node<KeyType, DataType> next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data) {
            this.key = key;
            this.data = data;
            next = null;
        }
    }

    @Override
    public Iterator<KeyType> iterator() {
        return new HashMapIterator();
    }

    // Iterators are used to iterate over collections like so:
    // for (Key key : map) { doSomethingWith(key); }
    private class HashMapIterator implements Iterator<KeyType> {
        // TODO: Add any relevant data structures to remember where we are in the list.
        private int current = 0;
        private int nbReturned = 0;
        /**
         * TODO Worst Case : O(n)
         * Determine if there is a new element remaining in the hashmap.
         */
        public boolean hasNext() { return nbReturned < size();
        }

        /**
         * TODO Worst Case : O(n)
         * Return the next new key in the hashmap.
         */
        public KeyType next() {
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException();

            if( nbReturned < map.length ) {
                nbReturned++;
                return map[current - 1].key;
            }

            return null;
        }
    }
}
