package FinalAssessment;

public class Perfect {
    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
        Tree(int x) { this.x = x; }
    }

    static class Result {
        int height;        
        int perfectHeight; // height of largest perfect subtree
        Result(int h, int ph) { height = h; perfectHeight = ph; } // constructor 
    }

    static int maxSize = 0; // size of largest perfect subtree found

    static Result dfs(Tree node) {
        if (node == null) return new Result(0, 0); // base case

        Result left = dfs(node.l); // recurse left
        Result right = dfs(node.r); // recurse right

        int height = Math.max(left.height, right.height) + 1; // height of tree rooted here

        // largest perfect subtree rooted here depends on balanced children
        int perfectHeight = Math.min(left.perfectHeight, right.perfectHeight) + 1; 

        int size = (1 << perfectHeight) - 1; // size of perfect subtree
        maxSize = Math.max(maxSize, size); // update global max size if needed

        return new Result(height, perfectHeight); // return heights
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.l = new Tree(2);
        root.l.r = new Tree(4);

        root.r = new Tree(3);
        root.r.l = new Tree(5);
        root.r.l.l = new Tree(7);
        root.r.l.r = new Tree(8);

        root.r.r = new Tree(6);
        root.r.r.l = new Tree(9);
        root.r.r.r = new Tree(18);
        root.r.r.r.l = new Tree(11);

        dfs(root);

        System.out.println("\n✅ Final Largest perfect subtree size = " + maxSize);
    }
}
