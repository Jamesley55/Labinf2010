package tp2;

import java.util.Iterator;

public class HashMap<KeyType, DataType> implements Iterable<KeyType> {

    private static final int DEFAULT_CAPACITY = 20;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private final Node<KeyType, DataType>[] map;
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
    private void increaseCapacity() {
        capacity = capacity * CAPACITY_INCREASE_FACTOR;
    }

    /**
     * TODO Average Case : O(n)
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        increaseCapacity();
        Node<KeyType, DataType>[] newMap = new Node[capacity];

        for (int i = 0; i < map.length; i++) {
            Node<KeyType, DataType> currentNode = map[i];
            while (currentNode != null) {
                newMap[i] = currentNode;
                newMap[i] = newMap[i].next;
                currentNode = map[i].next;
            }
        }


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
        if (map[index] != null) {
            do {
                if (map[index].key == key) {
                    return true;
                }
            } while (map[index].next != null);
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
        DataType data = null;
        int index = hash(key);
        if (containsKey(key)) {
            do {
                if(map[index].key == key){
                data = map[index].data;

                }
            } while (map[index].next != null);
        }
        return data;
    }

    /**
     * TODO Average Case : O(1) , Worst case : O(n)
     * Assigns a value to a key
     *
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        DataType data = null;
        int index = hash(key);
        if (containsKey(key)) {
            do {
                if (map[index].key == key) {
                    data = map[index].data;
                    map[index].data = value;
                }
            }
            while (map[index].next != null);
        } else {
            map[index] = new Node<KeyType, DataType>(key, value);
            size++;
        }
        return data;

    }

    /**
     * TODO Average Case : O(1)
     * Removes the node attached to a key
     *
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        DataType data = null;
        int index = hash(key);
        if (containsKey(key)) {
            Node<KeyType, DataType> previous = null;
            Node<KeyType, DataType> next = map[index].next;
            do {
                if (map[index].key == key) {
                    data = map[index].data;
                    map[index].data = null;
                    previous.next = map[index].next;
                    map[index] = previous;
                }
                previous.next = map[index];
            }
            while (map[index].next != null);
        }
        return data;
    }

    /**
     * TODO Worst Case : O(1)
     * Removes all nodes contained within the map
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            map[i] = null;
        }
        size = 0;
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

        /**
         * TODO Worst Case : O(n)
         * Determine if there is a new element remaining in the hashmap.
         */
        public boolean hasNext() {
            return false;
        }

        /**
         * TODO Worst Case : O(n)
         * Return the next new key in the hashmap.
         */
        public KeyType next() {
            return null;
        }
    }
}
