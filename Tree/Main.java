package Tree;

public class Main {

static String[] tree = {
        "D", "A", "F", "E", "B", "R", "T",
        "G", "Q", null, null, "V", null, "J", "L"
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

    public static void main(String[] args) {


        // Select Index to be checked
         int index = 1;

         // Prints Index 
        System.out.println("\n\nNode at index " + index + ": " + tree[index]);

        
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int parent = getParent(index);
        System.out.println("Left child: " + (left != -1 ? tree[left] : "None"));
        System.out.println("Right child: " + (right != -1 ? tree[right] : "None"));
        System.out.println("Parent: " + (parent != -1 ? tree[parent] : "None"));
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


