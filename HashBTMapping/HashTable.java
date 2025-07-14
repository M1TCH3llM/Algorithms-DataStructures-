package HashBTMapping;

public class HashTable {
     private final int SIZE = 10;
    private Node[] buckets;

    static class Node {
        Integer key;
        Integer value;
        Node next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        buckets = new Node[SIZE];
    }

    private int hash(Integer key) {
        return Math.abs(key) % SIZE;
    }

    public void put(Integer key, Integer value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
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

    public Integer get(Integer key) {
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
}
