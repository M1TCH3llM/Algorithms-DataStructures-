package QueueArray;

public class Main {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

         circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);

          // Should print 1
        System.out.println("Peek: " + circularQueue.peek()); 

          // Should print 1
        System.out.println("Dequeue: " + circularQueue.dequeue()); 

          // Should print 2
        System.out.println("Peek after dequeue: " + circularQueue.peek()); 

                circularQueue.enqueue(6);
                circularQueue.enqueue(7);


        circularQueue.print();

    }
}
