package Tree.TreeLL;

public class Main {

    static String[] tree = {
        "D", "A", "F", "E", "B", "R", "T",
        "G", "Q", "None", "None", "V", "None", "J", "L"
    };
public static void main(String[] args) {
    TreeLL list = new TreeLL();

    for (String value : tree) {
        if (value != null && !value.equals("None")) {
            list.insertAtEnd(value);
        }
    }

  list.printList();

    TreeLL.TreeNode root = list.createTreeFromLinkedList();

    System.out.println("\nPreorder Tree Traversal:");
    list.printPreorder(root);

    System.out.println("\nInorder Tree Traversal:");
    list.printInorder(root);
}
}