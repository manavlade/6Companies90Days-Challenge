
/*
 Question 4
 Given an integer array nums and an integer k, return the maximum sum of a non-empty 
 subsequence of that array such that for every two consecutive integers in the 
 subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
A subsequence of an array is obtained by deleting some number of elements (can be zero) 
from the array, leaving the remaining elements in their original order.
*/
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question4 {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int [] > q = new PriorityQueue<>((a,b) -> b[0] -a[0]);
        q.add(new int[] {nums[0], 0});
        int ans = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            while (i - q.peek()[1] > k) {
                q.remove();
            }

            int curr = Math.max(0, q.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            q.add(new int[] {curr, i});
        }
        return ans;
    }

}
