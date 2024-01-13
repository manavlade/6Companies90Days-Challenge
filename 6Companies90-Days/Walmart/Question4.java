/*
 Question 4 
 Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
*/

import java.util.HashMap;
import java.util.Map;

public class Question4 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);

            int result = 0;
            for (int i : map.keySet()) 
                if(k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
                    result++;
                
            
        
        return result;
    }

}
