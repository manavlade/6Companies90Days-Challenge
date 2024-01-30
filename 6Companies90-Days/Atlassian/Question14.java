/*
 Question 14
 =You are given an integer array nums. We call a subset of nums good if its product 
 can be represented as a product of one or more distinct prime numbers.
For example, if nums = [1, 2, 3, 4]:
[2, 3], [1, 2, 3], and [1, 3] are good subsets with products 6 = 2*3, 6 = 2*3, and 3 = 3 respectively.
[1, 4] and [4] are not good subsets with products 4 = 2*2 and 4 = 2*2 respectively.
Return the number of different good subsets in nums modulo 109 + 7.
A subset of nums is any array that can be obtained by deleting some (possibly none or 
all) elements from nums. Two subsets are different if and only if the chosen indices to
 delete are different.
 */
public class Question14 {
    
        static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        static final int NUM_MAX = 30;
        static final int MOD = 1000000007;

        public int numberOfGoodSubsets(int[] nums) {
            // Step 1: Count the frequency of each number in 'nums'
            int[] freq = new int[NUM_MAX + 1];
            for (int num : nums) {
                ++freq[num];
            }

            // Step 2: Initialize an array 'f' for dynamic programming
            int[] f = new int[1 << PRIMES.length];
            f[0] = 1;

            // Step 3: Update 'f[0]' based on the frequency of the number 1
            for (int i = 0; i < freq[1]; ++i) {
                f[0] = f[0] * 2 % MOD;
            }

            // Step 4: Iterate through numbers from 2 to NUM_MAX
            for (int i = 2; i <= NUM_MAX; ++i) {
                if (freq[i] == 0) {
                    continue;
                }

                // Step 5: Check if each prime factor of 'i' appears at most once
                int subset = 0, x = i;
                boolean check = true;
                for (int j = 0; j < PRIMES.length; ++j) {
                    int prime = PRIMES[j];
                    if (x % (prime * prime) == 0) {
                        check = false;
                        break;
                    }
                    if (x % prime == 0) {
                        subset |= (1 << j);
                    }
                }
                if (!check) {
                    continue;
                }

                // Step 6: Dynamic programming - update 'f' based on the current number 'i'
                for (int mask = (1 << PRIMES.length) - 1; mask > 0; --mask) {
                    if ((mask & subset) == subset) {
                        f[mask] = (int) ((f[mask] + ((long) f[mask ^ subset]) * freq[i]) % MOD);
                    }
                }
            }

            // Step 7: Calculate the final answer based on 'f'
            int ans = 0;
            for (int mask = 1, maskMax = (1 << PRIMES.length); mask < maskMax; ++mask) {
                ans = (ans + f[mask]) % MOD;
            }

            // Step 8: Return the result
            return ans;
        }
    }