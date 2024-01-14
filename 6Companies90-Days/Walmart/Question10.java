/*
 Question 10
 Given a string s and a dictionary of strings wordDict, return true if s can be 
 segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question10 {
     public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; 

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                String word = s.substring(start, end);
                if (dp[start] && wordSet.contains(word)) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    
    }
}