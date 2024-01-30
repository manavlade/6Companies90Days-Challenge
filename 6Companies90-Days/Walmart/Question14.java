/*
 Question 14
You are given a positive integer 0-indexed array nums. A subset of the array nums is 
square-free if the product of its elements is a square-free integer.
A square-free integer is an integer that is divisible by no square number other than 1.
Return the number of square-free non-empty subsets of the array nums. Since the answer 
may be too large, return it modulo 109 + 7. A non-empty subset of nums is an array that
can be obtained by deleting some (possibly none but not all) elements from nums. Two 
subsets are different if and only if the chosen indices to delete are different.
 */
public class Question14 {
    int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    private static final int MOD = 1000000007;

    public int squareFreeSubsets(int[] nums) {
        Long[][] memo = new Long[31][1 << 11];
        int[] freq = new int[31];
        for (int num : nums) {
            freq[num]++;
        }
        // because factors 4, 9 and 25 are not square-free, so that
        // numbers that contain these factors does not contribute
        // to square-free product subsets. Set their frequencies to
        // zeroes here.
        for (int i = 4; i <= 30; i += 4) {
            freq[i] = 0;
        }
        for (int i = 9; i <= 30; i += 9) {
            freq[i] = 0;
        }
        freq[25] = 0;
        long result = dfs(2, 0, freq, memo);
        for (int i = 0; i < freq[1]; i++) {
            result = (result * 2) % MOD;
        }
        return (int) ((result - 1 + MOD) % MOD);
    }

    private long dfs(int num, int mask, int[] freq, Long[][] memo) {
        // termination condition
        if (num >= 31) {
            return 1;
        }
        if (memo[num][mask] != null) {
            return memo[num][mask];
        }
        // normal condition
        // do not add num
        long result = dfs(num + 1, mask, freq, memo);
        // do add num
        boolean addNum = true;
        int maskNext = mask;
        for (int i = 0; i < primes.length; i++) {
            if (num % primes[i] == 0) {
                if ((maskNext & (1 << i)) > 0) {
                    addNum = false;
                    break;
                } else {
                    maskNext |= (1 << i);
                }
            }
        }
        if (addNum && freq[num] > 0) {
            result = (result + freq[num] * dfs(num + 1, maskNext, freq, memo) % MOD) % MOD;
        }
        memo[num][mask] = result;
        return result;
    }

}
