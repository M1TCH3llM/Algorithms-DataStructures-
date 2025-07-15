package HashBTMapping;

public class PostOrder {

    // Tree node class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from inorder and postorder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashTable inorderMap = new HashTable(); // Use custom hashmap

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i); // map value to its index in inorder
        }

        int[] postIndex = {postorder.length - 1}; // simulate reference last element of array
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postIndex, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int[] postIndex, HashTable inorderMap) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex[0]--]; // move across array from right to left
        TreeNode root = new TreeNode(rootVal);

        Integer rootIdx = inorderMap.get(rootVal);
        if (rootIdx == null) return null;

        // Build right sub tree
        root.right = buildTreeHelper(inorder, postorder, rootIdx + 1, inEnd, postIndex, inorderMap);
        // Build left subtree
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIdx - 1, postIndex, inorderMap);

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
        PostOrder sol = new PostOrder();

        int[] postorder = {9, 1, 2, 12, 7, 5, 3, 11, 4, 8};
        int[] inorder   = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};

        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.println("Preorder of constructed tree:");
        sol.printLevelOrder(root);
    }
  
}
