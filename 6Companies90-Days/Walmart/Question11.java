
/*
 Question 11
 You are given a 0-indexed string s and a dictionary of words dictionary. You have
  to break s into one or more non-overlapping substrings such that each substring is present in dictionary. 
 There may be some extra characters in s which are not present in any of the substrings.
Return the minimum number of extra characters left over if you break up s optimally.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question11 {
    public int minExtraChar(String s, String[] dictionary) {
        int maxVal = s.length() +1;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 1; i <= s.length(); ++i) {
            dp[i] = dp[i-1] +1;
            for (int j = 1; j <= i; ++j) {
                if(dictionarySet.contains(s.substring(i -j, i))){
                    dp[i] = Math.min(dp[i], dp[i-j]);
                }
            }
        }
        return dp[s.length()];
    }

}
