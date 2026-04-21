import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BinarySearchTreeTest {

    @Test
    void getRoot() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertNull(bst.getRoot());

        bst.add(10);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getValue());
    }

    @Test
    void setRoot() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        TreeNode<Integer> node = new TreeNode<>(5, null, null);

        bst.setRoot(node);

        assertEquals(5, bst.getRoot().getValue());
    }

    @Test
    void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertEquals(3, bst.countNodes());
    }

    @Test
    void contains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(20);
        bst.add(5);

        assertTrue(bst.contains(20));
        assertFalse(bst.contains(100));
    }

    @Test
    void countNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);

        assertEquals(4, bst.countNodes());
    }

    @Test
    void countLeafNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);

        assertEquals(2, bst.countLeafNodes());
    }

    @Test
    void getHeight() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);

        assertEquals(3, bst.getHeight());
    }

    @Test
    void printInorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bst.printInorder(bst.getRoot());

        String output = out.toString().trim();

        assertTrue(output.contains("5"));
        assertTrue(output.contains("10"));
        assertTrue(output.contains("15"));
    }

    @Test
    void printPreorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bst.printPreorder(bst.getRoot());

        String output = out.toString().trim();

        assertTrue(output.contains("10"));
        assertTrue(output.contains("5"));
        assertTrue(output.contains("15"));
    }

    @Test
    void printPostorder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bst.printPostorder(bst.getRoot());

        String output = out.toString().trim();

        assertTrue(output.contains("5"));
        assertTrue(output.contains("15"));
        assertTrue(output.contains("10"));
    }

    @Test
    void delete() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(10);
        bst.add(5);
        bst.add(15);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertEquals(2, bst.countNodes());
    }
}