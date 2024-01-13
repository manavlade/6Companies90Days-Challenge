
/*
 Question 2 
 You are given an integer array nums and an integer k. 
 You want to find a subsequence of nums of length k that has the largest sum.
Return any such subsequence as an integer array of length k.
A subsequence is an array that can be derived from another array by
 deleting some or no elements without changing the order of the remaining elements.

 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Question2 {
      public int[] maxSubsequence(int[] nums, int k) {
      PriorityQueue<Integer> pq=new PriorityQueue<>();
       List<Integer> v=new ArrayList<>(); 
        for(int x:nums){
            pq.add(x);
            v.add(x);
        }
        
        int[] ans=new int[k];
        
        for(int i=0;i<nums.length-k;i++)
            v.remove(pq.remove());
        
        for(int i=0;i<k;i++)
            ans[i]=v.get(i);
        
        return ans;
    }
    
}
