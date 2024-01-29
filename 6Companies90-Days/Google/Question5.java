import java.util.Arrays;

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
