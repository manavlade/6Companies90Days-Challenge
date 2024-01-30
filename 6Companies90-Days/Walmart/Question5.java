/*
 Question 5
 You are given two strings s and t of the same length and an integer maxCost.
You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| 
(i.e., the absolute difference between the ASCII values of the characters).
Return the maximum length of a substring of s that can be changed to be the same 
as the corresponding substring of t with a cost less than or equal to maxCost.
 If there is no substring from s that can be changed to its corresponding substring from t, return 0.
*/
public class Question5 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int [] costArray = new int[n];

        for (int i = 0; i < n; i++) {
            costArray[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int current = 0;
        int maxL =0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            current += costArray[end];

            while (current > maxCost) {
                current -= costArray[start];
                start++;
            }
            maxL = Math.max(maxL, end-start+1);
        }
        return maxL;
    }

}
