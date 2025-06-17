package Palindrome;

public class Main {
    public static void main(String[] args) {
       Palindrome list = new Palindrome();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(1);

        System.out.println("Initial list:");
        list.printList();
        
        System.out.println("");
        // Reverse the linked list
        list.reverse();
        System.out.println("Reversed list:");
        list.printList();
        System.out.println("");
        // Check if the list is a palindrome
      
        if (list.isPalindrome()) {
            System.out.println("The list is a palindrome.");
        } else {
            System.out.println("The list is not a palindrome.");
        }
    
      
    }


    }

