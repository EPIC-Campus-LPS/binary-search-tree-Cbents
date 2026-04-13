import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        try (Scanner sc = new Scanner(new File("/home/cadenbents/IdeaProjects/binary-search-tree-Cbents/src/data.txt"))) {
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    int val = sc.nextInt(); // Directly read integers
                    bst.add(val);
                } else {
                    sc.next(); // Skip non-integers
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bst.countLeafNodes());


    }
}