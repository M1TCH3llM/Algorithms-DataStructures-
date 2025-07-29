package HashBTMapping;

import java.util.List;

public class PrePostOrder {

    static class TreeNode {
        String val;
        TreeNode left, right;

        TreeNode(String val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(List<String> pre, List<String> post, int[] preIndex, int l, int h, int size) {
        // Use all elements in pre order 
        if (preIndex[0] >= size || l > h)
            return null;
            // System.out.println("branch split:" + h);
            // System.out.println("root pointer: " + l);
            

        // create root in sub tree with pre index then increment to move to the next spot for future recursive calls
        TreeNode root = new TreeNode(pre.get(preIndex[0]));
        preIndex[0]++;

        //if current post order range only has one element it is a child
        if (l == h)
            return root;

        // look for next value in preorder = left child in post order
        int i;
        for (i = l; i <= h; i++) {
            if (pre.get(preIndex[0]) == post.get(i))
                break;
        }
        // System.out.println("left most child " + i);
        if (i <= h) {
            // build left sub tree 
            root.left = buildTree(pre, post, preIndex, l, i, size);
            // right subtree
            root.right = buildTree(pre, post, preIndex, i + 1, h - 1, size);
        }

        return root;
    }

    public static TreeNode constructTree(List<String> pre, List<String> post) {
        int[] preIndex = {0};
        int size = pre.size();
        return buildTree(pre, post, preIndex, 0, size - 1, size);
    }

    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        TreeNode[] queue = new TreeNode[100];
        String[] output = new String[100];
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

            output[outputIndex++] = String.valueOf(current.val);
            queue[rear++] = current.left;
            queue[rear++] = current.right;
        }

        int lastNonNull = outputIndex - 1;
        while (lastNonNull >= 0 && "null".equals(output[lastNonNull])) {
            lastNonNull--;
        }

        System.out.print("[");
        for (int i = 0; i <= lastNonNull; i++) {
            System.out.print(output[i]);
            if (i < lastNonNull) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        PrePostOrder sol = new PrePostOrder();

          List<String> preorder = List.of("A", "B", "D", "E", "C", "F", "G");
          List<String> postorder = List.of("D", "E", "B", "F", "G", "C", "A");

        TreeNode root = constructTree(preorder, postorder);

        System.out.println("Solution");
        sol.printLevelOrder(root);
    }
}
