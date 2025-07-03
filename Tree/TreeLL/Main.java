package Tree.TreeLL;

public class Main {

    // Level-order array, “None” means “no node here”
    static String[] tree = {
        "D", "A", "F", "E", "B", "R", "T",
        "G", "Q", "None", "None", "V", "None", "J", "L"
    };

    // ─────────────────────────────────────────────────────────────
    // Basic node class for a *linked* binary tree
    static class TreeNode {
        // Store Node Value
        String val;
        // Declairs left and right retrace
        TreeNode left, right;
        TreeNode(String v) { val = v; }
    }

  
    static TreeNode build(int index) {
        // Index outside the array OR “None” placeholder → no node
        if (index >= tree.length || tree[index] == null || tree[index].equals("None"))
            return null;

            // Convert flat tree to linked binary 
            // creates new node based on index position
        TreeNode node = new TreeNode(tree[index]);
        // Recursively builds left and right child to structure
        node.left  = build(2 * index + 1);   // left child formula
        node.right = build(2 * index + 2);   // right child formula
        return node;
    }

    // Traversals on the linked structure
    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        //Build the linked tree once 
        TreeNode root = build(0);

        //Traversals (now totally pointer-based) 
        System.out.println("Pre-order :");
        preorder(root);   System.out.println();

        System.out.println("In-order  :");
        inorder(root);    System.out.println();

        System.out.println("Post-order:");
        postorder(root);  System.out.println();
    }
}
