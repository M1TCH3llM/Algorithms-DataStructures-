package Queue;

public class Main {

public static void main(String[] args) {
    Queue list = new Queue();
    
    list.insertAtEnd(20);
    list.insertAtEnd(25);
    list.insertAtEnd(26);
    list.insertAtEnd(30);
    list.insertAtEnd(37);

     System.out.println("Initial list:");
        list.printList();

        list.deleteAtFirst(1);

System.out.println("Ater delete:");
        list.printList();
    

     list.insertAtEnd(39);

     System.out.println("New Queue :");
        list.printList();

        list.deleteAtFirst(1);

System.out.println("Ater delete 2:");
        list.printList();
        


}

    
}
