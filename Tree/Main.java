package Tree;

public class Main {

static String[] tree = {
        "D", "A", "F", "E", "B", "R", "T",
        "G", "Q", "None", "None", "V", "None", "J", "L"
    };

    // get_right_child(index)
    public static int getRightChild(int index) {
        int right = 2 * index + 2;
        if (right < tree.length && tree[right] != null) {
            return right;
        }
        return -1;
    }

    // get_left_child(index)
    public static int getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left < tree.length && tree[left] != null) {
            return left;
        }
        return -1;
    }
    // get_parent(index)
    public static int getParent(int index) {
        if (index == 0 || index >= tree.length || tree[index] == null) {
            return -1;
        }
        return (index - 1) /2;
    }

    // Preorder Traversal Root --> Left --> Right
    public static void preorder(int index) { 
        if (index < 0 || index >= tree.length || tree[index] == null) return;

        System.out.print(tree[index] + " ");
        //Uses other functions to get children left and right of root. 
        // Get children left of index
        preorder(getLeftChild(index));
        // Get children right of index
        preorder(getRightChild(index));

    }
    // In Order Left --> Root --> Right
    public static void inorder(int index) { 
        if (index < 0 || index >= tree.length || tree[index] == null) return;

        //Uses other functions to get children left and right of root. 
        // Get children left of index
        inorder(getLeftChild(index));
        System.out.print(tree[index] + " ");
        // Get children right of index
       inorder(getRightChild(index));

    }


    // PostOrder Left --> Right --> Root
    public static void postorder(int index) { 
        if (index < 0 || index >= tree.length || tree[index] == null) return;

        //Uses other functions to get children left and right of root. 
        // Get children left of index
        postorder(getLeftChild(index));
        // Get children right of index
       postorder(getRightChild(index));
        System.out.print(tree[index] + " ");

    }

    public static void main(String[] args) {

        // Select Index to be checked
         int index = 6;

         // Prints Index 
        System.out.println("\n\nNode at index " + index + ": " + tree[index]);


        int left = getLeftChild(index);
        int right = getRightChild(index);
        int parent = getParent(index);
        System.out.println("Left child: " + (left != -1 ? tree[left] : "None"));
        System.out.println("Right child: " + (right != -1 ? tree[right] : "None"));
        System.out.println("Parent: " + (parent != -1 ? tree[parent] : "None"));

        System.out.println("Preorder:");
        preorder(0); // Starts from root
        System.out.println(" ");
        System.out.println("Inorder:");
        inorder(0); // Starts from root
         System.out.println(" ");
        System.out.println("Postorder:");
        postorder(0); // Starts from root
    }

}

// On the binary tree array implementation write the following methods:
// tree = [ 'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', None, None, 'V', None, 'J', 'L']
// get_right_child(index)
// get_left_child(index)
// get_parent(index)
//  preorder(index)
// inorder(index)
// postorder(index)


// Algorithm: Inorder (root) 
// 1. If (root = NULL): 
// a. Exit
// 2. Inorder (left child of root)
// 3. Visit (root) 
// 4. Inorder (right child of root) 

// Algorithm: Preorder (root) 
// 1. If (root = NULL): 
// a. Exit
// 2. Visit (root) 
// 3. Preorder (left child of root) // Recursive call to Preorder for traversing 
//  // the left subtree
// 4. Preorder (right child of root) // Recursive call to Preorder for traversing the 
//  //