/*
 Question 15
 Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. 
 The two subsequences are disjoint if they do not both pick a character at the same index.
Return the maximum possible product of the lengths of the two palindromic subsequences.
A subsequence is a string that can be derived from another string by deleting some or no characters
 without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.
 */
public class Question15 {
    public int maxProduct(String s) {
        int N = s.length();
        int[] dp = new int[1 << N];
        for (int m = 1; m < 1 << N; ++m) {
            if (Integer.bitCount(m) == 1)
                dp[m] = 1;
            else {
                int lb = Integer.numberOfTrailingZeros(m & -m), hb = 31 - Integer.numberOfLeadingZeros(m);
                dp[m] = Math.max(dp[m - (1 << lb)], Math.max(dp[m - (1 << hb)],
                        dp[m - (1 << lb) - (1 << hb)] + (s.charAt(lb) == s.charAt(hb) ? 2 : 0)));
            }
        }
        int ans = 0;
        for (int m = 1; m < 1 << N; ++m) {
            ans = Math.max(ans, dp[m] * dp[(1 << N) - 1 - m]);
        }
        return ans;
    }
}
