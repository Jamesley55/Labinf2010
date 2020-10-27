import java.util.LinkedList;
import java.util.List;

public class AvlTree<ValueType extends Comparable<? super ValueType>> {

    // Only node which has its parent to null
    private BinaryNode<ValueType> root;

    public AvlTree() {
    }

    /**
     * TODO Worst case : O ( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * Should call balance only if insertion succeeds
     * AVL Trees do not contain duplicates
     *
     * @param value value to add to the tree
     */
    public void add(ValueType value) {
        BinaryNode<ValueType> head = root;
        if (root == null) {
            root = new BinaryNode<ValueType>(value, null);
        } else {
            BinaryNode<ValueType> parentNode = root;
            while ( root!= null) {
                if (value.compareTo(root.value) <= 0){
                    parentNode = root;
                    root = root.left;}
                else{
                    parentNode = root;
                    root = root.right;}
            }
            if (value.compareTo(parentNode.value) <= 0){
                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.left = root;
                root.parent = parentNode;
                if(root.parent.right == null ) root.height++;
            }


            else{
                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.right = root;
                root.parent = parentNode;
                if(root.parent.left == null ) root.height++;

            }
            root = head;
            balance(root);
        }
    }

    /**
     * TODO Worst case : O ( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * Should call balance only if removal succeeds
     *
     * @param value value to remove from the tree
     */
    public void remove(ValueType value) {
        BinaryNode<ValueType> head = root;

            while (value.compareTo(root.value) != 0) {
                if (value.compareTo(root.value) <= 0){
                    root = root.left;}
                else{
                    root = root.right;}
            }
            if(root != null){
                BinaryNode<ValueType> left = root.left;
                BinaryNode<ValueType> right = root.right;
                root.parent.left = left;
                root.parent.right = right;
                root = head;
                balance(root);
                root.height--;
            }
    }

    /**
     * TODO Worst case : O ( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Verifies if the tree contains value
     *
     * @param value value to verify
     * @return if value already exists in the tree
     */
    public boolean contains(ValueType value) {
        BinaryNode<ValueType> head = root;
        while ( root!= null ) {
             if (value.compareTo(root.value) == 0){
                 root = head;
                return true;
             }
            else if (value.compareTo(root.value) < 0){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        root = head;
        return false;
    }

    /**
     * TODO Worst case : O( 1 )
     * Returns the max level contained in our root tree
     *
     * @return Max level contained in our root tree
     */
    public int getHeight() {
        return root.height;
    }

    /**
     * TODO Worst case : O( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Returns the node which has the minimal value contained in our root tree
     *
     * @return Node which has the minimal value contained in our root tree
     */
    public ValueType findMin() {
        /* loop down to find the leftmost leaf */
        BinaryNode<ValueType> head = root;

        while (root != null) {
            root = root.left;
        }
        if(root == null){
            return null;
        }else{
            BinaryNode<ValueType> value = root;
            root = head;
            return value.value;
        }

    }


    /**
     * TODO Worst case : O( n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * Returns all values contained in the root tree in ascending order
     *
     * @return Values contained in the root tree in ascending order
     */
    public List<ValueType> infixOrder() {
        List < ValueType> res = new LinkedList<>();
        java.util.Stack < BinaryNode<ValueType> > stack = new java.util.Stack < > ();
        BinaryNode<ValueType> curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.value);
            curr = curr.right;
        }
        return res;
    }

    /**
     * TODO Worst case : O( n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Returns all values contained in the root tree in level order from top to bottom
     *
     * @return Values contained in the root tree in level order from top to bottom
     */
    public List<ValueType> levelOrder() {
        return new LinkedList<>();

    }

    /**
     * TODO Worst case : O( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Balances the whole tree
     *
     * @param node Node to balance all the way to root
     */
    private void balance(BinaryNode<ValueType> node) {

    }

    /**
     * TODO Worst case : O ( 1 )
     * <p>
     * Single rotation to the left child, AVR Algorithm
     *
     * @param node1 Node to become child of its left child
     */
    private void rotateLeft(BinaryNode<ValueType> node1) {
        BinaryNode<ValueType> node2 = node1.left;
        BinaryNode<ValueType> node3 = node2.right;
        BinaryNode<ValueType> parent1 = node1.parent;
        if  (node1.parent != null) {
            if (parent1.value.compareTo(node2.value) < 0 ) {
                parent1.right = node2;
            }
            else if (parent1.value.compareTo(node2.value) > 0 ) {
                parent1.left = node2;
            }
        }
        if (node3 == null) {
            node2.parent = parent1;
            node2.right = node1;
            node1.parent = node2;
            node1.left = null;
        }
        else {
            node2.parent = parent1;
            node2.right = node1;
            node1.parent = node2;
            node1.left = node3;
            node3.parent = node1;
        }
        if(node1.value.compareTo(root.value) == 0) {
            root = node2;
        }


    }

    /**
     * TODO Worst case : O ( 1 )
     * <p>
     * Single rotation to the right, AVR Algorithm
     *
     * @param node1 Node to become child of its right child
     */
    private void rotateRight(BinaryNode<ValueType> node1) {

        ValueType tempValue = node1.value;
        node1.value = node1.right.value;
        node1.right.value = tempValue;


    }

    static private class BinaryNode<ValueType> {
        ValueType value;

        BinaryNode<ValueType> parent; // Pointer to the node containing this node

        BinaryNode<ValueType> left = null; // Pointer to the node on the left which should contain a value below this.value
        BinaryNode<ValueType> right = null; // Pointer to the node on the right which should contain a value above this.value

        int height = 0;

        BinaryNode(ValueType value, BinaryNode<ValueType> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
