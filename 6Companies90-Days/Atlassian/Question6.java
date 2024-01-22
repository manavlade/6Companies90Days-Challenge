import java.util.ArrayList;
import java.util.List;
/*
 Question 6
 You are given a 0-indexed string s, a string a, a string b, and an integer k.
An index i is beautiful if:
0 <= i <= s.length - a.length
s[i..(i + a.length - 1)] == a
There exists an index j such that:
0 <= j <= s.length - b.length
s[j..(j + b.length - 1)] == b
|j - i| <= k
Return the array that contains beautiful indices in sorted order from smallest to largest.
 */
public class Question6 {

    // Function to find pattern matching indices for a given pattern in a text
    void getPatternMatchingIndex(String s, String a, List<Integer> v) {
        // Concatenate pattern 'a' with a special character '@' and the text 's'
        String t = a + "@" + s;
        // List to store the Longest Prefix Suffix (lps) array for the concatenated
        // string 't'
        List<Integer> lps = new ArrayList<>();
        lps.add(0); // Initialize lps with 0 at the beginning

        // Loop to build the lps array using the KMP algorithm
        for (int i = 1; i < t.length(); ++i) {
            int ind = lps.get(i - 1);

            // While loop to find the longest prefix suffix
            while (ind > 0 && t.charAt(ind) != t.charAt(i)) {
                ind = lps.get(ind - 1);
            }

            // Update lps array based on the comparison of characters
            lps.add((t.charAt(ind) == t.charAt(i)) ? ind + 1 : 0);
        }

        // Loop to identify indices where pattern 'a' matches in the text 's'
        for (int i = 0; i < lps.size(); ++i) {
            if (lps.get(i) == a.length()) {
                v.add(i - 2 * a.length());
            }
        }
    }

    // Function to find beautiful indices based on patterns 'a' and 'b'
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();

        // Call getPatternMatchingIndex to find matching indices for pattern 'a'
        getPatternMatchingIndex(s, a, v1);

        // Call getPatternMatchingIndex to find matching indices for pattern 'b'
        getPatternMatchingIndex(s, b, v2);

        // Loop to find beautiful indices based on conditions
        for (int i = 0, j = 0; i < v1.size(); ++i) {
            while (j < v2.size() && v1.get(i) > v2.get(j) && Math.abs(v1.get(i) - v2.get(j)) > k) {
                j++;
            }

            // Check conditions for beautiful index and add to the result list
            if (j < v2.size() && Math.abs(v1.get(i) - v2.get(j)) <= k) {
                ans.add(v1.get(i));
            }
        }

        return ans;
    }
}
