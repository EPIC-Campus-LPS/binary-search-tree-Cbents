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

                //Case 1: Nothing except root or temp has no children
                if (temp.getLeftChild() == null && temp.getRightChild() == null){
                    if (value.compareTo(temp.getValue()) > 0){
                        temp.setRightChild(new TreeNode<>(value, null, null));
                        numNode ++;
                        break;
                    }
                    else if (value.compareTo(temp.getValue()) <= 0){
                        temp.setLeftChild(new TreeNode<>(value, null, null));
                        numNode ++;
                        break;
                    }
                }

                //Case 2: Right Child Handling
                if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() != null){
                    temp = temp.getRightChild();
                    continue;
                }
                else if (value.compareTo(temp.getValue()) > 0 && temp.getRightChild() == null){
                    temp.setRightChild(new TreeNode<>(value, null, null));
                    numNode++;
                    break;
                }
                else if (value.compareTo(temp.getValue()) <= 0 && temp.getLeftChild() != null){
                    temp = temp.getLeftChild();
                    continue;
                }
                else if (value.compareTo(temp.getValue()) <= 0 && temp.getLeftChild() == null){
                    temp.setLeftChild(new TreeNode<>(value, null, null));
                    numNode++;
                    break;
                }
                else{
                    break;
                }
                //The whole thing is a big FUCKING MESSSS
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



