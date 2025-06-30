package QueueArray;

public class CircularQueue {
    private int maxSize; // Max size of the circular queue

    private int[] queueArray; // Array 

    private int front; // Index front element

    private int rear; // Index rear

    // constructor to initialize the circle element

    public CircularQueue(int size)
    {
        maxSize = size;
        queueArray = new int[maxSize];

         // Initially set front and rear to -1 to indicate an empty queue
        front = -1;  
        rear = -1;
    }

    public void enqueue(int item)
    {
        if (isEmpty())
        {
            front = 0;
            rear = 0;
            queueArray[rear] = item;
        }
        else
        {
            rear = (rear + 1) % maxSize;
            if (rear == front)
            {                 // Circular increment of rear index
                System.out.println("Queue is full. Cannot enqueue.");

                // reset rear ro its previous value
                rear =(rear -1 + maxSize) % maxSize;
              } else {
                 queueArray[rear] = item;
              }

        }
    }
      // method to dequeue (remove) an item from the circular queue
    public int dequeue() 
    {
        int item = -1; // Assuming -1 represents an empty value

        if (!isEmpty()) 
        {
            item = queueArray[front];
            if (front == rear) {
                  // Reset front and rear to -1 to indicate an empty queue
                front = -1;
                rear = -1;  
            } 
           else 
            {
                 // Circular increment of front index
                front = (front + 1) % maxSize;  
            }
        } 
       else 
        {
            System.out.println("Queue is empty. Cannot dequeue.");
        }

        return item;
    }

    // Method to peek at the front element of the circular queue without removing it
    public int peek() 
    {
        if (!isEmpty()) 
        {
            return queueArray[front];
        } 
       else 
        {
            System.out.println("Queue is empty. No peek value.");
            return -1; // Assuming -1 represents an empty value
        }
    }
    public int[] getQueueArray() {
    return queueArray;
}

    // Method to check if the circular queue is empty
    public boolean isEmpty() 
    {
        return front == -1 && rear == -1;
    }

     public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
