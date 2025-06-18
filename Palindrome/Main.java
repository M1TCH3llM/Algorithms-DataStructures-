package Palindrome;

public class Main {
    public static void main(String[] args) {
       Palindrome list = new Palindrome();

        int[] input = {1, 2, 3, 2, 1}; // Example input that is a palindrome
        for (int num : input) {
            list.insertAtEnd(num);
        }

        // int[] input = {1, 2, 3, 2, 3}; // Example input that is a palindrome
        // for (int num : input) {
        //     list.insertAtEnd(num);
        // }

        // int[] input = {1, 2, 3, 3, 2, 1}; // Example input that is a palindrome
        // for (int num : input) {
        //     list.insertAtEnd(num);
        // }

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

