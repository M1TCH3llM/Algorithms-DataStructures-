package HightBalanceTree;


public class Main {
       public static void main(String[] args) {
       HightBalanceTree tree = new HightBalanceTree();

      int[] arr = {52, 36, 38, 68, 24, 23, 27, 26, 59, 60, 72, 70, 80, 75,76 };
            for (int x : arr) {
               tree.insert(new Node(x));
            }

            System.out.println("");
            System.out.println("Inorder Traversal:");

            tree.display();

            System.out.println("\ndelete 52:");
            tree.delete(52);
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


