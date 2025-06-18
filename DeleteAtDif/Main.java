package DeleteAtDif;

public class Main {
    public static void main(String[] args) {
        DeleteAtDif list = new DeleteAtDif();

        int[] input = {1,2,3,4,5,6,7,8};
        for (int num : input) {
            list.insert(num);
        }

        System.out.print("Original list: ");
        list.printList();

        int diff = 2; // Set the difference value
        int difference = diff + 1;//
        list.deleteAtDifference(difference);

        System.out.print("After deleting with difference " + diff + ": ");
        list.printList();
    }
}

