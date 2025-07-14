package BinarySearchTree;

public class Main {

    public static void main(String[] args) {


    BinarySearchTree tree = new BinarySearchTree();

      int[] arr = {52, 36, 38, 68, 24, 23, 27, 26, 59, 60, 72, 70, 80, 75,76 };
            for (int x : arr) {
               tree.insert(new Node(x));
            }

            System.out.println("");
            System.out.println("Inorder Traversal:");

            tree.display();

            System.out.println("");
            System.out.println("\nSearching for 36: " + tree.search(36));
            System.out.println("\nSearching for 0: " + tree.search(0));

            System.out.println("\ndelete 52:");
            tree.delete(52);
            tree.display();

            System.out.println("\ndelete 0:");
            tree.delete(0);
            tree.display();
            
        }
}

// Binary search tree implementation
// Search 
// Insert
// Delete
// Traversal (In-order, Pre-order, Post-order)

// hight of binary search tree
// find sum of leaf nodes 
