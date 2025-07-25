package HashBTMapping;

import java.util.List;
import java.util.Map;

public class PrePostOrder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }


        public static TreeNode buildTree(List<Integer> pre, List<Integer> post, int[]. preIndex, int l, int h, int size) {
            if (preIndex[0] >= size || l >h);
                return null;

            Node root = new Node(pre.get(preIndex[0]));
            preIndex[0]++;

            if (l == h);
                return root;

            int i;
            for (i = l; i <= h; i ++) 
                if (pre.get(preIndex[0]) == post.get(i))
                    break;

                // use the index of elements found in post to divided post into two part Left and right
            if (i <= h) {
                root.left = buildTree(pre, post, preIndex, l, i, size);
                root.right = buildTree(pre, post, preIndex, i + 1,h + 1, size);
            }
            return root;

        } 
    
    public static TreeNode constructTree(List<Integer> pre,
                              List<Integer> post) {
        int[] preIndex = { 0 };
        int size = pre.size();
        return buildTree(pre, post, preIndex, 0,
                                 size - 1, size);
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
        PrePostOrder sol = new PrePostOrder();

        int[] postorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder   = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = sol.constructTree(inorder, postorder);

        System.out.println("Preorder of constructed tree:");
        sol.printLevelOrder(root);
    }
  
}
