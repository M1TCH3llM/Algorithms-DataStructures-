// PREORDER:{1,2,4,8,9,10,11,5,3,6,7}
// INORDER:{8,4,10,9,11,2,5,1,6,3,7}


package HashBTMapping;

public class PreOrder {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from inorder and preorder
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        HashTable inorderMap = new HashTable(); // Use custom hashmap

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i); // map value to its index in inorder
        }

        int[] preIndex = {0}; // simulate reference first element of array
        return buildTreeHelper(inorder, preorder, 0, inorder.length -1, preIndex, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] preorder, int inStart, int inEnd, int[] preIndex, HashTable inorderMap) {
        if (inStart > inEnd) return null;

         // Take current preorder element as root
        int rootVal = preorder[preIndex[0]];
        preIndex[0]++; // move to next preorder element
        TreeNode root = new TreeNode(rootVal);

        Integer rootIdx = inorderMap.get(rootVal);
        if (rootIdx == null) return null;

        // Build left subtree first (because preorder is Root->Left->Right)
        root.left = buildTreeHelper(inorder, preorder, inStart, rootIdx - 1, preIndex, inorderMap);
         // Then build right subtree
        root.right = buildTreeHelper(inorder, preorder, rootIdx + 1, inEnd, preIndex, inorderMap);

        return root;
    }

    public void printLevelOrder(TreeNode root) {
    if (root == null) {
        System.out.println("[]");
        return;
    }

    // We'll simulate a queue using a fixed-size array
    TreeNode[] queue = new TreeNode[100];  // Large enough to hold all nodes
    String[] output = new String[100];     // Store node values and "null"
    int front = 0;
    int rear = 0;
    int outputIndex = 0;

    queue[rear++] = root;

    while (front < rear) {
        TreeNode current = queue[front++];

        // inserts null if no value 
        if (current == null) {
            output[outputIndex++] = "null";
            continue;
        }

        // Add value to output
        output[outputIndex++] = String.valueOf(current.val);

        // Enqueue left and right children (even if they're null)
        queue[rear++] = current.left;
        queue[rear++] = current.right;
    }

    // Trim trailing nulls from output (to match your desired format)
    int lastNonNull = outputIndex - 1;
    while (lastNonNull >= 0 && "null".equals(output[lastNonNull])) {
        lastNonNull--;
    }

    // Print the array
    System.out.print("[");
    for (int i = 0; i <= lastNonNull; i++) {
        System.out.print(output[i]);
        if (i != lastNonNull) System.out.print(", ");
    }
    System.out.println("]");
}

    public static void main(String[] args) {
        PreOrder sol = new PreOrder();

        int[] preorder = {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] inorder   = {8,4,10,9,11,2,5,1,6,3,7};

        TreeNode root = sol.buildTree(inorder, preorder);

        System.out.println("Preorder of constructed tree:");
        sol.printLevelOrder(root);
    }
  
}


