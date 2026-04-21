import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BST MENU =====");
            System.out.println("1. Load tree from file");
            System.out.println("2. Add value");
            System.out.println("3. Delete value");
            System.out.println("4. Contains value");
            System.out.println("5. Print traversals");
            System.out.println("6. Print stats");
            System.out.println("7. Clear tree");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter file path: ");
                String path = input.next();

                try (Scanner sc = new Scanner(new File(path))) {
                    while (sc.hasNext()) {
                        if (sc.hasNextInt()) {
                            bst.add(sc.nextInt());
                        } else {
                            sc.next();
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }

                System.out.println("Tree loaded.");

            }
            else if (choice == 2) {
                System.out.print("Value to add: ");
                bst.add(input.nextInt());
            }
            else if (choice == 3) {
                System.out.print("Value to delete: ");
                Integer removed = bst.delete(input.nextInt());
                System.out.println("Deleted: " + removed);
            }
            else if (choice == 4) {
                System.out.print("Value to check: ");
                System.out.println("Contains: " + bst.contains(input.nextInt()));
            }
            else if (choice == 5) {
                if (bst.getRoot() == null) {
                    System.out.println("Tree is empty.");
                } else {
                    System.out.println("\nPREORDER:");
                    bst.printPreorder(bst.getRoot());

                    System.out.println("\nINORDER:");
                    bst.printInorder(bst.getRoot());

                    System.out.println("\nPOSTORDER:");
                    bst.printPostorder(bst.getRoot());
                }
            }
            else if (choice == 6) {
                System.out.println("Nodes: " + bst.countNodes());
                System.out.println("Leaf Nodes: " + bst.countLeafNodes());
                System.out.println("Height: " + bst.getHeight());
            }
            else if (choice == 7) {
                bst.root = null;
                bst.numNode = 0;
                System.out.println("Tree cleared.");
            }
            else if (choice == 8) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}