package HashSlingingSlasher;


public class HashTable {
    private final int SIZE = 10; // Number of buckets
    private Node[] buckets; // array of node refanceseEach index in this array is a bucket that can hold Linked List

    public HashTable() {
        buckets = new Node[SIZE];//  Constructor initilazes buckets array with size slot
    }

    private int hash(Integer key) {
        return Math.abs(key) % SIZE; // take key ensurse it NAN uses modulo to find remander to assighn buckets
    }

    public void put(Integer key, String value) { // methode that inserts new K-V pair or updates Excisting
        int index = hash(key); // computes index with hash function for a given key
        Node newNode = new Node(key, value); // creates new Node object to store the key value pair 


        // incerts node directly in no collition
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            //
            Node current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public String get(Integer key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < SIZE; i++) {
            Node current = buckets[i];
            System.out.print(i + ": ");
            while (current != null) {
                System.out.print("[" + current.key + ", " + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }


}
