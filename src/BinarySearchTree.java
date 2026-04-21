/**
 * A generic Binary Search Tree (BST) implementation that stores elements
 * in sorted order using the Comparable interface.
 *
 * @param <E> the type of elements stored in the tree
 */
public class BinarySearchTree<E extends Comparable<E>> {

    int numNode = 0;
    public TreeNode<E> root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    public BinarySearchTree() {

    }

    /**
     * Returns the root node of the binary search tree.
     *
     * @return the root TreeNode of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Sets the root node of the binary search tree.
     *
     * @param root the new root node
     */
    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    /**
     * Adds a value to the binary search tree while maintaining BST ordering rules.
     *
     * @param value the value to insert into the tree
     */
    public void add(E value){
        if (getRoot() == null){
            root = new TreeNode<>(value, null, null);
            numNode ++;
        }
        else{
            TreeNode<E> temp = root;
            while (true) {

                //Case 1: Nothing except root or temp has no children
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (value.compareTo(temp.getValue()) > 0) {
                        temp.setRightChild(new TreeNode<>(value, null, null));
                        numNode++;
                        break;
                    } else if (value.compareTo(temp.getValue()) <= 0) {
                        temp.setLeftChild(new TreeNode<>(value, null, null));
                        numNode++;
                        break;
                    }
                }

                //Case 2: Everything else
                if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() != null) {
                    temp = temp.getRightChild();

                }
                else if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() == null) {
                    temp.setRightChild(new TreeNode<>(value, null, null));
                    numNode++;
                    break;
                }
                else if (value.compareTo(temp.getValue()) <= 0 && temp.getLeftChild() != null) {
                    temp = temp.getLeftChild();

                }
                else if (value.compareTo(temp.getValue()) <= 0 && temp.getLeftChild() == null) {
                    temp.setLeftChild(new TreeNode<>(value, null, null));
                    numNode++;
                    break;
                }
            }
        }
    }

    /**
     * Checks whether a given value exists in the binary search tree.
     *
     * @param value the value to search for
     * @return true if the value exists, false otherwise
     */
    public boolean contains(E value){
        TreeNode<E> temp = root;
        while (true) {

            //Case 1: Nothing except root or temp has no children
            if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                if (value.compareTo(temp.getValue()) > 0) {
                    return false;
                }
                else if (value.compareTo(temp.getValue()) < 0) {
                    return false;
                }
                else{
                    return true;
                }
            }

            //Case 2: Everything else
            if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() != null) {
                temp = temp.getRightChild();

            }
            else if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() == null) {
                return false;
            }
            else if (value.compareTo(temp.getValue()) <= 0 && temp.getLeftChild() != null) {
                temp = temp.getLeftChild();

            }
            else if (value.compareTo(temp.getValue()) < 0 && temp.getLeftChild() == null) {
                return false;
            }
            else{
                return true;
            }
        }

    }

    /**
     * Returns the total number of nodes currently in the tree.
     *
     * @return number of nodes
     */
    public int countNodes(){
        return numNode;
    }

    /**
     * Counts the number of leaf nodes (nodes with no children) in the tree.
     *
     * @return number of leaf nodes
     */
    public int countLeafNodes()
    {
        return traverse(root);

    }

    /**
     * Returns the height of the binary search tree.
     *
     * @return height of the tree
     */
    public int getHeight(){
        return heightS(root);
    }

    /**
     * Prints the tree using an inorder traversal (Left → Root → Right).
     *
     * @param node the starting node for traversal
     */
    public void printInorder(TreeNode<E> node){
        if (node.getLeftChild() == null && node.getRightChild() == null){
            System.out.println(node.getValue());
        }
        else{
            if (node.getLeftChild() != null) { // Left Subtree
                printInorder(node.getLeftChild());
            }

            System.out.println(node.getValue()); // Print

            if (node.getRightChild() != null){ // Right Subtree
                printInorder(node.getRightChild());
            }
        }
    }

    /**
     * Prints the tree using a preorder traversal (Root → Left → Right).
     *
     * @param node the starting node for traversal
     */
    public void printPreorder(TreeNode<E> node){
        if (node.getLeftChild() == null && node.getRightChild() == null){
            System.out.println(node.getValue());

        }
        else{
            System.out.println(node.getValue()); // Print
            if (node.getLeftChild() != null) { // Left Subtree
                printPreorder(node.getLeftChild());
            }
            if (node.getRightChild() != null){ // Right Subtree
                printPreorder(node.getRightChild());
            }

        }
    }

    /**
     * Prints the tree using a postorder traversal (Left → Right → Root).
     *
     * @param node the starting node for traversal
     */
    public void printPostorder(TreeNode<E> node){
        if (node.getLeftChild() == null && node.getRightChild() == null){
            System.out.println(node.getValue());
        }
        else{
            if (node.getLeftChild() != null) { // Left Subtree
                printPostorder(node.getLeftChild());
            }

            if (node.getRightChild() != null){ // Right Subtree
                printPostorder(node.getRightChild());
            }

            System.out.println(node.getValue()); // Print
        }
    }

    /**
     * Deletes a value from the binary search tree while maintaining BST structure.
     * Handles leaf nodes, nodes with one child, and nodes with two children.
     *
     * @param value the value to delete
     * @return the deleted value, or null if not found
     */
    public E delete(E value){
        TreeNode<E> temp = root;
        TreeNode<E> parent = null;

        // Step 1: Find node
        while (temp != null && value.compareTo(temp.getValue()) != 0){
            parent = temp;

            if (value.compareTo(temp.getValue()) > 0){
                temp = temp.getRightChild();
            }
            else{
                temp = temp.getLeftChild();
            }
        }

        // Not found
        if (temp == null){
            return null;
        }

        // Step 2: Case 1 - Leaf node
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            if (temp == root){
                root = null;
            }
            else if (parent.getLeftChild() == temp){
                parent.setLeftChild(null);
            }
            else{
                parent.setRightChild(null);
            }
        }

        // Step 3: Case 2 - One child
        else if (temp.getLeftChild() == null || temp.getRightChild() == null){
            TreeNode<E> child;

            if (temp.getLeftChild() != null){
                child = temp.getLeftChild();
            }
            else{
                child = temp.getRightChild();
            }

            if (temp == root){
                root = child;
            }
            else if (parent.getLeftChild() == temp){
                parent.setLeftChild(child);
            }
            else{
                parent.setRightChild(child);
            }
        }

        // Step 4 Two children
        else{
            TreeNode<E> successorParent = temp;
            TreeNode<E> successor = temp.getRightChild();

            // Find leftmost in right subtree
            while (successor.getLeftChild() != null){
                successorParent = successor;
                successor = successor.getLeftChild();
            }

            // Replace value
            temp.setValue(successor.getValue());

            // Remove successor
            if (successorParent.getLeftChild() == successor){
                successorParent.setLeftChild(successor.getRightChild());
            }
            else{
                successorParent.setRightChild(successor.getRightChild());
            }
        }

        numNode--;
        return value;
    }

    /**
     * Recursively counts leaf nodes in the tree.
     *
     * @param node the current node
     * @return number of leaf nodes in the subtree
     */
    private int traverse(TreeNode<E> node){
        if (node.getLeftChild() == null && node.getRightChild() == null){
            return 1;
        }
        else if (node.getRightChild() != null && node.getLeftChild() != null){
            return traverse(node.getLeftChild()) + traverse(node.getRightChild());
        }
        else if (node.getRightChild() == null && node.getLeftChild() != null){
            return traverse(node.getLeftChild());
        }
        else if (node.getRightChild() != null && node.getLeftChild() == null){
            return traverse(node.getRightChild());
        }
        else{
            return 0;
        }
    }

    /**
     * Recursively calculates the height of the tree.
     *
     * @param node the current node
     * @return height of the subtree
     */
    private int heightS(TreeNode<E> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightS(node.getLeftChild());
        int rightHeight = heightS(node.getRightChild());

        return 1 + Math.max(leftHeight, rightHeight);
    }

}



