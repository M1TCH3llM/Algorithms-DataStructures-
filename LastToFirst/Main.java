package LastToFirst;

public class Main {
    public static void main(String[] args) {
       LastToFirst list = new LastToFirst();

       int[] input = {1,2,3,4};
       for (int num : input) {
           list.insertAtEnd(num);
       }

  

        System.out.println("Original List:");
        list.printList();

        System.out.println("After moving last to front:");
        list.moveLastToFirst();
        list.printList();
    }
}
