/*
 Question 5 
 Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.
Test cases are designed so that the answer will fit in a 32-bit integer.
 */
import java.util.Arrays;

public class Question5 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int median = (n % 2 == 0) ? (nums[n/2] + nums[n/2 -1]) / 2 : nums[n/2];

        int totalMoves = 0;

        for (int i : nums) {
            totalMoves += Math.abs(i - median);
        }

        return totalMoves;
    }
    
}
