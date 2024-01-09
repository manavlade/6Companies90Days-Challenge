/*
 Question 10
 You are given a 0-indexed array of positive integers nums.
A subarray of nums is called incremovable if nums becomes strictly increasing on removing the subarray. 
For example, the subarray [3, 4] is an incremovable subarray of [5, 3, 4, 6, 7] 
because removing this subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.
Return the total number of incremovable subarrays of nums.
Note that an empty array is considered strictly increasing.
A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class Questopm10 {
    public int incremovableSubarrayCount(int[] nums) {
        int len = nums.length, maxi = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (check(nums, i, j)) {
                    maxi++;
                }
            }
        }
        return maxi;
    }

    private boolean check(int[] nums, int low, int high) {
        for (int i = 0; i < low - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        if (low > 0 && high < nums.length - 1 && nums[low - 1] >= nums[high + 1]) {
            return false;
        }
        for (int i = high + 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


