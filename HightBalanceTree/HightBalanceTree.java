package HightBalanceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HightBalanceTree {
    
 Node root;

    public void insert(Node newNode) {
    root = insertHelper(root, newNode);
}

    private Node insertHelper(Node node, Node newNode) {

        if (node == null) return newNode;

        if (newNode.data < node.data) {
            node.left = insertHelper(node.left, newNode);
        } else if (newNode.data > node.data) {
            node.right = insertHelper(node.right, newNode);
        } else {
            return node;
        }
        // Update hight of current node
        updateHeight(node);

        // compute balancing factor
        int balance = getBalance(node);

         // Case 1: To tall on left subtree, so we need a single right rotation
    if (balance > 1 && newNode.data < node.left.data) {
        System.out.println("Rotate right");
        return rightRotate(node);
        
    }

    // Case 2: To tall on right subtree, so we need a single left rotation
    if (balance < -1 && newNode.data > node.right.data) {
        System.out.println("Rotate left");

        return leftRotate(node);
    }

    // Case 3: Left subtree Right child, left rotate child, right rotate current root
    if (balance > 1 && newNode.data > node.left.data) {
         System.out.println("Rotate left the right");

        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // Case 4: Right subtree  Left child right rotate child, left rotate current root
    if (balance < -1 && newNode.data < node.right.data) {
                System.out.println("Rotate right then left");

        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node; 
    }


    //  public void display() {

    //     displayHelper(root);
    //  }
    //  // In-order traversal of the tree
    //     // Left, Root, Right
    //  private void displayHelper(Node root) {
    //     if(root != null) {
    //         System.out.print(root.data + " ");
    //         displayHelper(root.left);
    //         displayHelper(root.right);
    //     } 
    //  }

    public void display() {
        // Calls tree print and prints entire code 
    System.out.println(treePrint(root));
}

// Builds a top-down tree view
private String treePrint(Node root) {
    // Checks for Empty tree
    if (root == null) return "(empty)";

    // calls helper to calculate hight of tree
    int maxLevel = maxLevel(root);
    // accumulates string of all text including spacing
    StringBuilder sb = new StringBuilder();

    // calls recursive function, 1 = level one, maxLevel is height, sb String builder(collect data)
    printNodeInternal(Collections.singletonList(root), 1, maxLevel, sb);
    // returns the formatted string to display method
    return sb.toString();
}

// Recursive internal printer
private void printNodeInternal(List<Node> nodes, int level, int maxLevel, StringBuilder sb) {
    // Stops function if node is empty
    if (nodes.isEmpty() || allElementsNull(nodes)) return;

    // Number of levels before current
    int floor = maxLevel - level;
    // number of slashes needed for each level
    int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
    // calculates leading spaces 
    int firstSpaces = (int) Math.pow(2, floor) - 1;
    // number of spaces in between
    int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

    // First space on each line
    sb.append(" ".repeat(firstSpaces));

    // new list that holds next level
    List<Node> newNodes = new ArrayList<>();
    // loopes through nodes on current level
    for (Node node : nodes) {
        // if its not null we collect value and record children for next level
        if (node != null) {
            // adds to stringbuilder
            sb.append(node.data);
            // adds children to next level for recursion
            newNodes.add(node.left);
            newNodes.add(node.right);
        } else {
            // if node is empty we account for space
            sb.append(" ");
            // adds null for children to keep structure
            newNodes.add(null);
            newNodes.add(null);
        }

        sb.append(" ".repeat(betweenSpaces));
    }
    sb.append("\n");

    for (int i = 1; i <= edgeLines; i++) {
        for (Node node : nodes) {
        sb.append(" ".repeat(Math.max(firstSpaces - i, 0)));
             if (node == null) {
                sb.append(" ".repeat(edgeLines * 2 + i + 1));
                continue;
            }

            sb.append(node.left != null ? "/" : " ");
            sb.append(" ".repeat(i * 2 - 1));
            sb.append(node.right != null ? "\\" : " ");

            sb.append(" ".repeat(edgeLines * 2 - i));
        }
        sb.append("\n");
    }

    printNodeInternal(newNodes, level + 1, maxLevel, sb);
}

// Helper to find max depth
private int maxLevel(Node node) {
    return node == null ? 0 : Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
}

// Checks if all nodes in a list are null
private boolean allElementsNull(List<Node> list) {
    for (Node n : list) if (n != null) return false;
    return true;
}

     
     // Search for a node with the given data
        // Returns true if found, false otherwise
     public boolean search(int data) {
         return searchHelper(root, data);
     }

     private boolean searchHelper(Node root, int data) {
        // Base case: if the root is null, the data is not found
        // If the root is not null, check if the data matches the root's data
        if(root == null) {
            return false;
        }
        // If the data is equal to the root's data, return true
        else if (root.data == data) {
            return true;
        }
        // If the data is less than the root's data, search in the left subtree
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        else {
            // If the data is greater than the root's data, search in the right subtree
            return searchHelper(root.right, data);
        }
     }

   public void delete(int data) {
    if (search(data)) {
        System.out.println("inside delete");
        root = deleteHelper(root, data); 
    } else {
        System.out.println("Node with value " + data + " not found in the tree.");
    }
}

    private Node deleteHelper(Node root, int data) {
                System.out.println("inside delete Helper");

        if(root == null) {
            return root;
        }
        // Traverse the tree to find the node to be deleted
        // If the data is less than the root's data, go to the left subtree
        else if (data < root.data) {
            root.left = deleteHelper(root.left, data);
            System.out.println("left travel");

        }
        // If the data is greater than the root's data, go to the right subtree
        else if (data > root.data) {
            root.right = deleteHelper(root.right, data);
            System.out.println("right travel");

        }
        else {
            // Node with no child
            // Leaf node 
            if (root.left == null && root.right == null) {
                root = null;
                System.out.println("leaf node");
            } 
            else if (root.right != null) { // find successor
                root.data = successor(root);
                root.right = deleteHelper(root.right, root.data);
            }
            else if (root.left != null) { // find predecessor
                root.data = predecessor(root);
                root.left = deleteHelper(root.left, root.data);
            }
        }

        if (root == null) return null;

        updateHeight(root);
        // Update height
                

                // Check balance
                int balance = getBalance(root);

                // Left Left
                if (balance > 1 && getBalance(root.left) >= 0){
                    System.out.println("Rotate Right");
                    return rightRotate(root);
                }

                   // Case 1: To tall on left subtree, so we need a single right rotation
 
                // Left Right
                if (balance > 1 && getBalance(root.left) < 0) {
                    System.out.println("Rotate left then right");
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }

                // Right Right
                if (balance < -1 && getBalance(root.right) <= 0) {
                    System.out.println("Rotate Left");
                    return leftRotate(root);
                }
                // Right Left
                if (balance < -1 && getBalance(root.right) > 0) {
                    System.out.println("Rotate right then left");
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }


        return root;
    }

    // Find the successor of the node to be deleted
    // The successor is the minimum value in the right subtree
    private int successor(Node root) { // find the minimum value in the right child of this root node
       root = root.right;
       // Traverse to the leftmost node in the right subtree
       // The leftmost node will have the minimum value
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    // Find the predecessor of the node to be deleted
    // The predecessor is the maximum value in the left subtree
    private int predecessor(Node root) {
         root = root.left;
         // Traverse to the rightmost node in the left subtree
            // The rightmost node will have the maximum value
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
    public int getTreeHeight() {
    return height(root);
}

    private int height(Node n) {
        // if node is null return 0 else return stored hight value
        return (n == null) ? 0 : n.height;
    }

    private void updateHeight(Node n) {
        if (n != null) {
    n.height = 1 + Math.max(height(n.left), height(n.right));
        }
}

    public int getRootBalanceFactor() {
    return getBalance(root);
}

    private int getBalance(Node n) {
        // if n is null return 0, else return Balance factor 
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        //rotate right
        x.right = y;
        y.left = z;

        // update hights
        updateHeight(y);
        updateHeight(x);

        // System.out.println("Rotate Right");

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        //rotate left
        y.left = x;
        x.right = z;

        // update hights
        updateHeight(x);
        updateHeight(y);

        // System.out.println("Rotate Left");

        return y;
    }
    


}
