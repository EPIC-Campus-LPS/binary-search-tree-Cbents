public class BinarySearchTree<E extends Comparable<E>> {
    public TreeNode<E> root;

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }


    public void add(E value){
        if (getRoot() == null){
            root = new TreeNode<>(value, null, null);
        }
        else{
            TreeNode<E> temp = root;
            while (true){
                if (temp.getLeftChild() == null && temp.getRightChild() == null){
                    break;
                }
                else if(value.compareTo(temp.getValue()) <= 0){ //Left
                    temp = temp.getLeftChild();
                }
                else if(value.compareTo(temp.getValue()) > 0){
                    temp = temp.getRightChild();
                }
            }
            //Write one more compareTo statement to determine the new node placement!!!!
        }
    }

    public boolean contains(E value){
        return false;
    }

    public int countNodes(){

    }

    public int countLeafNodes(){

    }
    public int getHeight(){

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


}
