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
                if(value.compareTo(root.value) == 0)
                    break;
                else if (value.compareTo(root.value) < 0){
                    parentNode = root;
                    root = root.left;}
                else{
                    parentNode = root;
                    root = root.right;}
            }
            if(value.compareTo(parentNode.value) == 0)
                ;
            else if (value.compareTo(parentNode.value) < 0){
                // add a new node at the end of the left node

                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.left = root;
                root.parent = parentNode;
                // reorganise height between each node
                boolean lastRight =  root.parent.right == null;
                while(root.parent != null && lastRight){
                root.parent.height += 1;
                root = root.parent;}

            }
            else{
                // add a new node at the end of the right node
                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.right = root;
                root.parent = parentNode;
                // reorganise height between each node
                boolean lastLeft =  root.parent.left == null;
                while(root.parent != null && lastLeft ){
                    root.parent.height += 1;
                    root = root.parent;
                }

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
        while(value.compareTo(root.value) !=0){
            if(value.compareTo(root.value) <= 0){
                root = root.left;
            }else{
                root = root.right;
            }
        }


        // Case 1: node to be deleted has no children
        if (root.left == null && root.right == null)
        {

            if (root != head) {
                if (root == root.parent.left ) {
                    root.parent.left = null;
                } else {
                    root.parent.right = null;
                }
            }
            else {
                head = null;
            }
        }


        // Case 2: node to be deleted has  one child
        else if (root.left != null || root.right != null)
        {
            BinaryNode<ValueType> child = (root.left != null)? root.left: root.right;
            if (root != head)
            {
                if (root == root.parent.left) {
                    root.parent.left = child;
                } else {
                    root.parent.right = child;


                }
            }

            else {
                root = child;
            }

        }

        // Case 3: node to be deleted has two child
        else if (root.left != null && root.right != null)
        {
            BinaryNode<ValueType> child = (root.left != null)? root.left: root.right;
            if (root != head)
            {
                if (root == root.parent.left) {
                    root.parent.left = child;
                } else {
                    root.parent.right = child;
                }

            }
            else {
                root = child;
            }
        }
        root = head;
        balance(root);

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
       if(root == null){
           return -1;
       }else{
           int leftHeigh = 0;
           int rightHeight = 0;

           if(root.left != null){
               leftHeigh = root.left.height;
           }
           if(root.right != null){
               rightHeight = root.right.height;
           }

           int maxHeight =(leftHeigh > rightHeight)? leftHeigh: rightHeight;

           return maxHeight;
       }
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
        BinaryNode<ValueType> currentNode = root;
        if(currentNode == null){
            return null;
        }
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;


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
        BinaryNode<ValueType> leftChild = node1.left;
        BinaryNode<ValueType> parentNode = node1.parent;
        leftChild.parent = parentNode;
        node1.parent = leftChild;

        if (parentNode != null) {
            if (parentNode.value.compareTo(leftChild.value) < 0) {
                parentNode.right = leftChild;
            } else {
                parentNode.left = leftChild;
            }
        } else {
            root = leftChild;
        }
        node1.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node1;
        }
        leftChild.right = node1;

    }

    /**
     * TODO Worst case : O ( 1 )
     * <p>
     * Single rotation to the right, AVR Algorithm
     *
     * @param node1 Node to become child of its right child
     */
    private void rotateRight(BinaryNode<ValueType> node1) {

        BinaryNode<ValueType> rightChild = node1.right;
        BinaryNode<ValueType> parentNode = node1.parent;
        rightChild.parent = parentNode;
        node1.parent = rightChild;

        if (parentNode != null) {
            if (parentNode.value.compareTo(rightChild.value) < 0) {
                parentNode.right = rightChild;
            } else {
                parentNode.left = rightChild;
            }
        } else {
            root = rightChild;
        }
        node1.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node1;
        }
        rightChild.left = node1;


    }

    static private class BinaryNode<ValueType> {
        ValueType value;

        BinaryNode<ValueType> parent; // Pointer to the node containing this node

        BinaryNode<ValueType> left = null; // Pointer to the node on the left which should contain a value below this.value
        BinaryNode<ValueType> right = null; // Pointer to the node on the right which should contain a value above this.value
        int height = 1;


        BinaryNode(ValueType value, BinaryNode<ValueType> parent) {
            this.value = value;
            this.parent = parent;
        }


    }
}
