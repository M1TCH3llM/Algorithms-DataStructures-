package HightBalanceTree;


public class Main {
       public static void main(String[] args) {
       HightBalanceTree tree = new HightBalanceTree();

      int[] arr = {30, 20, 22, 40, 10, 25, 56, 34, 77, 39};
            for (int x : arr) {
               tree.insert(new Node(x));
            }

            System.out.println("");
            System.out.println("Inorder Traversal:");

            tree.display();
            System.out.println("\nTree Hight: " + tree.getTreeHeight());
            System.out.println("\nTree Balance Value: " + tree.getRootBalanceFactor());



            System.out.println("\ndelete 40:");
            tree.delete(40);
            tree.display();

            System.out.println("\ndelete 0:");
            tree.delete(0);
            tree.display();
            
            
            System.out.println("\nTree Hight: " + tree.getTreeHeight());
            System.out.println("\nTree Balance Value: " + tree.getRootBalanceFactor());

        }
      }
        


// hight balance tree
// Delete
// Insert / Build
// Rotate 


// TODO: update insert Helper
// update delete Helper


