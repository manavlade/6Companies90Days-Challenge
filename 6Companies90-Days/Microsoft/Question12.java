/*
 Question 12
 Given an integer array nums, 
 reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
You may assume the input array always has a valid answer.
 */
import java.util.Arrays;

public class Question12 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
       int [] temp = Arrays.copyOf(nums, nums.length);

       int mid = (n + 1) /2;
       
       int left = mid-1;
       int right = n-1;

       int index = 0;

       while (left >= 0 || right >= mid) {
        if(left >= 0){
            nums[index++] = temp[left--];
        }
        if(right >= mid){
            nums[index++] = temp[right--];
        }
       }
    }

}
