package HightBalanceTree;

public class Node {
    int data;
    // Reference to the left and right child nodes
    Node left, right;
    // store hight data 
    int height;

    public Node(int data) {
        this.data = data;
        this.height = 1; // new node is at hight one 
     
    }

}
