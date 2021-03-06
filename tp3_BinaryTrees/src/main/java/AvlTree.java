import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            while (root != null) {
                if (value.compareTo(root.value) == 0)
                    break;
                else if (value.compareTo(root.value) < 0) {
                    parentNode = root;
                    root = root.left;
                } else {
                    parentNode = root;
                    root = root.right;
                }
            }
            if (value.compareTo(parentNode.value) == 0)
                ;
            else if (value.compareTo(parentNode.value) < 0) {
                // add a new node at the end of the left node

                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.left = root;
                root.parent = parentNode;
            } else {
                // add a new node at the end of the right node
                root = new BinaryNode<ValueType>(value, parentNode);
                parentNode.right = root;
                root.parent = parentNode;

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
            if (value.compareTo(root.value) <= 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }


        // Case 1: node to be deleted has no children
        if (root.left == null && root.right == null) {

            if (root != head) {
                if (root == root.parent.left) {
                    root.parent.left = null;
                } else {
                    root.parent.right = null;
                }
            } else {
                head = null;
            }
        }


        // Case 2: node to be deleted has  one child
        else if (root.left != null || root.right != null) {
            BinaryNode<ValueType> child = (root.left != null) ? root.left : root.right;
            if (root != head) {
                if (root == root.parent.left) {
                    root.parent.left = child;
                } else {
                    root.parent.right = child;


                }
            } else {
                root = child;
            }

        }

        // Case 3: node to be deleted has two child
        else if (root.left != null && root.right != null) {
            BinaryNode<ValueType> child = (root.left != null) ? root.left : root.right;
            if (root != head) {
                if (root == root.parent.left) {
                    root.parent.left = child;
                } else {
                    root.parent.right = child;
                }

            } else {
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
        while (root != null) {
            if (value.compareTo(root.value) == 0) {
                root = head;
                return true;
            } else if (value.compareTo(root.value) < 0) {
                root = root.left;
            } else {
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
        if( root == null){
            return -1 ;
        }
        else if ( root.left == null && root.right == null){
            return 0 ;
        }
        else {
            return root.height;
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
        if (currentNode == null) {
            return null;
        }
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;


    }
     void updateHeight (BinaryNode<ValueType> root)
    {
         root.height = levelHeight(root) - 1 ;
    }

    /**
     * TODO Worst case : O( n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * Returns all values contained in the root tree in ascending order
     *
     * @return Values contained in the root tree in ascending order
     */
    public List<ValueType> infixOrder() {
        List<ValueType> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        java.util.Stack<BinaryNode<ValueType>> stack = new java.util.Stack<>();
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
        List<ValueType> res = new LinkedList<ValueType>();

        if (root == null) {
            return res;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sizeQueue = queue.size();
            while (sizeQueue > 0) {
                BinaryNode<ValueType> NodeTemp = queue.poll();

                res.add(NodeTemp.value);

                if (NodeTemp.left != null) {
                    queue.add(NodeTemp.left);
                }
                if (NodeTemp.right != null) {
                    queue.add(NodeTemp.right);
                }
                sizeQueue--;
            }
        }
        return res;

    }

    // log(n)
    int levelHeight(BinaryNode<ValueType> node){
        if(node == null){
            return 0;
        }
        return Math.max(levelHeight(node.right), levelHeight(node.left))+1;
    }

    /**
     * TODO Worst case : O( log n ) HAS TO BE ITERATIVE, NOT RECURSIVE
     * <p>
     * Balances the whole tree
     *
     * @param node Node to balance all the way to root
     */
    private void balance(BinaryNode<ValueType> node) {
           if(node != null){
               updateHeight(root);
               if(levelHeight(node.left) - levelHeight(node.right) > 1){
                   if(levelHeight(node.left.left) >= levelHeight(node.left.right) ){
                        rotateLeft(node);
                   }else{
                       rotateRight(node.left);
                       rotateLeft(node);
                   }
               }
                else if(levelHeight(node.right) - levelHeight(node.left) > 1){
                   if(levelHeight(node.right.right) >= levelHeight(node.right.left) ){
                       rotateRight(node);
                   }else{
                       rotateLeft(node.right);
                       rotateRight(node);
                   }
               }
           }
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
        BinaryNode<ValueType> node2 = node1.right;

        BinaryNode<ValueType> node3 = node2.left;
        BinaryNode<ValueType> parent1 = node1.parent;
        if  (parent1 != null) {
            if (node2.value.compareTo(parent1.value) > 0 ) {
                parent1.right = node2;
            }
            else if (node2.value.compareTo(parent1.value) < 0 ) {
                parent1.left = node2;
            }
        }
        if (node3 == null) {
            node2.parent = parent1;
            node2.left = node1;
            node1.parent = node2;
            node1.right = null;

        } else {
            node2.parent = parent1;
            node2.left = node1;
            node1.parent = node2;
            node1.right = node3;
            node3.parent = node1;
        }
        if(node1.value.compareTo(root.value) == 0) {
            root = node2;
        }


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
