/*
 Question 9
You are given a positive integer p. Consider an array nums (1-indexed) that consists
of the integers in the inclusive range [1, 2p - 1] in their binary representations. 
You are allowed to do the following operation any number of times: Choose two elements x and y from nums.
Choose a bit in x and swap it with its corresponding bit in y. Corresponding bit
refers to the bit that is in the same position in the other integer.
For example, if x = 1101 and y = 0011, after swapping the 2nd bit from the right, we have x = 1111 and y = 0001.
Find the minimum non-zero product of nums after performing the above operation any number of times. 
Return this product modulo 109 + 7.
Note: The answer should be the minimum product before the modulo operation is done.
 */
public class Question9 {
    public int mod = 1_000_000_007;
    public int minNonZeroProduct(int p) {
        if (p == 1)
            return 1;

        long mx = (long) (Math.pow(2, p)) - 1; // Calculate the maximum value of the sequence
        long sm = mx - 1; // Calculate the sum of the sequence excluding the last element
        long n = sm / 2; // Calculate the number of elements in the sequence
        long sum = rec(sm, n); // Calculate the product of non-zero elements

        return (int) (sum * (mx % mod) % mod);
    }

    public long rec(long val, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return (val % mod);

        long newVal = ((val % mod) * (val % mod)) % mod;

        if (n % 2 != 0) {
            return ((rec(newVal, n / 2) % mod) * (val % mod)) % mod;
        }

        return rec(newVal, n / 2) % mod;
    }
}
