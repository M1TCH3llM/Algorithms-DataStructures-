// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.
// Your algorithm's runtime complexity must be in the order of O(log n).
 
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
 
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1


package Problems;

public class Twentysix {
    

    public static int search(int[] nums, int target) {

       // index left and right index
        int left = 0;
        int right = nums.length -1;
        // System.out.println("right " + right);
                    // System.out.println("left " + left);


        while (left <= right) {
            // uses array position of left and right to determine mid
            int mid = left + (right - left) / 2;
            System.out.println("mid " + mid);
            // if mid is target return
            if (nums[mid] == target) {
            return mid;

            }
            // Checks if left is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the left Sorted position
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // moves right pointer left of mid because target is in left half
                      System.out.println("right 1 " + right);

                } else {
                    left = mid + 1; // advances left to mid plus one because target is right half
                                  System.out.println("left 1 " + left);

                }

            } else {
                  if(nums[mid] <= target && target < nums[right]) {
                    left = mid + 1; 
                                        System.out.println("left 2 " + left);

                } else {
                    right = mid - 1; // advances right to mid minus one because target is in left half
                       System.out.println("right 2 " + right);

                }
            }
        }

        return -1; // not found

    }

    public static void main(String[] args) {
         int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Target at: " + search(nums1, target1));

           int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(search(nums2, target2)); // Output: -1
           
        int[] nums3 = {6, 7, 0, 1, 2, 4, 5};
        int target3 = 3;
        System.out.println(search(nums3, target3)); // Output: -1
    }
}
