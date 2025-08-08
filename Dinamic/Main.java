package Dinamic;

public class Main {

    static int maxArray(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n]; // dp[i] = max sum ending at i

    dp[0] = arr[0];
    int res = dp[0];

    for (int i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]); // reuse dp[i-1]
        res = Math.max(res, dp[i]);
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