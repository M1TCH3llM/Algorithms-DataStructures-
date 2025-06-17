package LastToFirst;

public class Main {
    public static void main(String[] args) {
       LastToFirst list = new LastToFirst();

       list.insertAtEnd(1);
         list.insertAtEnd(2);
         list.insertAtEnd(3);
            list.insertAtEnd(4);

        System.out.println("Original List:");
        list.printList();

        System.out.println("After moving last to front:");
list.moveLastToFirst();
list.printList();
    }
}
