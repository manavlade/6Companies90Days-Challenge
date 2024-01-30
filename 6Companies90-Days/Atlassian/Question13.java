import java.util.HashMap;
import java.util.Map;
/*
 Question 13
You are given an integer array nums and an integer k.
The frequency of an element x is the number of times it occurs in an array.
An array is called good if the frequency of each element in this array is less than or equal to k.
Return the length of the longest good subarray of nums.
A subarray is a contiguous non-empty sequence of elements within an array.
 */

public class Question13 {
     public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int bad = 0;
        int result = 0;

        for (int left = 0, right = 0; right < n;) {
            int x = nums[right++];
            // Or
            // int x = nums[right];
            // right++
            if(map.merge(x, 1, Integer:: sum) >k){
                ++bad;
            }
            while (bad > 0) {
                int y = nums[left++];
                if(map.merge(y, -1, Integer:: sum) == k){
                    --bad;
                    // If after subtracting 1 from the frequency of y, the new frequency is equal to
                    // k, decrement the bad counter.
                }
            }
            result = Math.max(result, right-left);
        }
        return result;     
    }  
}
