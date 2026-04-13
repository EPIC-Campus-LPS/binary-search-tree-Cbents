public class BinarySearchTree<E extends Comparable<E>> {
    int numNode = 0;
    public TreeNode<E> root;

    public BinarySearchTree() {

    }


    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }


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

    public int countNodes(){
        return numNode;
    }

    public int countLeafNodes()
    {
        return traverse(root);

    }
    public int getHeight(){
        return 0;
    }

    public void printInorder(){

    }
    public void printPreorder(){

    }
    public void printPostorder(){

    }
    public E delete(E value){
        return value;
    }

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



}



