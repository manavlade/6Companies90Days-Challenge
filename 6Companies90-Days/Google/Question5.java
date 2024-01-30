import java.util.Arrays;
/*
 Question 5
You are given an array of non-negative integers nums and an integer k. In one operation,
you may choose any element from nums and increment it by 1.
Return the maximum product of nums after at most k operations. Since the answer may be 
very large, return it modulo 109 + 7. Note that you should maximize the product before 
taking the modulo. 
 */
public class Question5 {
    public int maximumProduct(int[] nums, int k) {
        
        int index = (nums.length - 1); 
        int i = 0; 
        long M = 1000000007;
       
        if (index + 1 == 1) {
            return (int) ((nums[0] + k) % M);
        }
        
        Arrays.sort(nums); 

        for (; i < index; i++) {
            int diff = nums[i + 1] - nums[i];
            // Tackeling the situation when (diff * i)<k
            if (diff == 0) {
                continue;
            } else if (diff * (i + 1) > k) {
                int j = 0;
                while (k != 0) {
                    nums[j]++;
                    k--;
                    j++;
                    if (j == i + 1)
                        j = 0;
                }
            } else {
                for (int j = 0; j <= i; j++) {
                    nums[j] += diff;
                }
                k -= diff * (i + 1);
            }

        }

        if (k > 0 && i == index) {
            while (k != 0) {
                nums[i]++;
                k--;
                i++;
                if (i == index + 1)
                    i = 0;

            }
        }

        long result = 1;
        for (i = 0; i < index + 1; i++) {
            result = (result * nums[i]) % M;
        }
        return (int) result;

    }
}
