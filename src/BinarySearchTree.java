public class BinarySearchTree<E extends Comparable<E>> {
    int numNode = 0;
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
            numNode ++;
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

            if (value.compareTo(temp.getValue()) <= 0){
                temp.setLeftChild(new TreeNode<>(value, null, null));
            }
            else{
                temp.setRightChild(new TreeNode<>(value, null, null));
            }
            numNode++;
        }
    }

    public boolean contains(E value){

        TreeNode<E> temp = root;
        while (true){
            if (temp.getLeftChild() == null && temp.getRightChild() == null){
                break;
            }
            else if(value.compareTo(temp.getValue()) < 0){
                temp = temp.getLeftChild();
            }
            else if(value.compareTo(temp.getValue()) == 0){
                return true;
            }
            else if (value.compareTo(temp.getValue()) > 0){
                temp = temp.getRightChild();
            }
        }

        return false;
    }

    public int countNodes(){
        return numNode;
    }

    public int countLeafNodes(){
        TreeNode<E> temp = root;
        while (true){
            if (temp.getLeftChild() == null && temp.getRightChild() == null){
                break;
            }
            else if(value.compareTo(temp.getValue()) < 0){
                temp = temp.getLeftChild();
            }
            else if(value.compareTo(temp.getValue()) == 0){
                return true;
            }
            else if (value.compareTo(temp.getValue()) > 0){
                temp = temp.getRightChild();
            }
        }
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
