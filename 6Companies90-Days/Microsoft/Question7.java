/*
 Question 7
 Given an array of integers nums and an integer k. 
 A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
 */
import java.util.ArrayList;

public class Question7 {
    public int numberOfSubarrays(int[] nums, int k) {
        return Count(nums, k) - Count(nums, k-1);
    }
    private static int Count(int[] nums, int k){
        int n = nums.length;
        int sI = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 != 0){
                sum++;
            }
            if(sum <= k) {
                count += i - sI +1;
            }

            while (sI <= i && sum > k) {
                if(nums[sI] % 2 != 0){
                    sum--;
                }
                sI++;
                if(sum <= k){
                    count += i - sI + 1;
                }
            }
        }
        return count;
    }
}