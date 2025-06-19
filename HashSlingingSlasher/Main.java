package HashSlingingSlasher;

//==================== Separate Chaining ===============================

public class Main {
    
     public static void main(String[] args) {
   HashTable table = new HashTable();

    table.put(100, "Spongebob");
    table.put(123, "Patrick");
    table.put(321, "Squidward");
    table.put(456, "Sandy");
    table.put(765, "Mr Krabs");
    table.put(555, "Plankton");
    table.put(987, "Gary");
    table.put(467, "Pearl");

   table.printTable();

    }
}

