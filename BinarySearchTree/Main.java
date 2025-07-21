package BinarySearchTree;

public class Main {

    public static void main(String[] args) {


    BinarySearchTree tree = new BinarySearchTree();

      int[] arr = {10, 12, 8, 6, 15, 9 };
            for (int x : arr) {
               tree.insert(new Node(x));
            }

            System.out.println("");
            System.out.println("Inorder Traversal:");

            tree.display();

            System.out.println("");
            System.out.println("\nSearching for 10: " + tree.search(10));
            System.out.println("\nSearching for 0: " + tree.search(0));

            System.out.println("\ndelete 6:");
            tree.delete(6);
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
