package Dinamic;

public class Main {

    static int maxArray(int[] arr) {
        // Store max sum so far 
        int res =arr[0];

        // max ending at current position
        int maxEnd = arr[0];

        for (int i = 1; i < arr.length; i ++) {

            // Either extend or start new from current
            maxEnd = Math.max(maxEnd + arr[i], arr[i]);
            System.out.println("arr " + arr[i]);
            System.out.println("maxEnd " + maxEnd);
            // Update result if new subarray sum is larger 
            res = Math.max(res, maxEnd);
            System.out.println("res " + res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Problem 1: " + maxArray(arr));
        
        int[] arr2 = {4,-1,2,1};
        System.out.println("Problem 2: " + maxArray(arr2));
    }


}

// Given an integer array nums, find the contiguous subarray (containing at least one number) which
//      *  has the largest sum and return its sum.
// Example:
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] 
// has the largest sum = 6.