/*
 Question 15
Given a string s and a string array dictionary, return the longest string in the
dictionary that can be formed by deleting some of the given string characters. If
there is more than one possible result, return the longest word with the smallest
lexicographical order. If there is no possible result, return the empty string.
 */

import java.util.List;

public class Question15 {
     public String findLongestWord(String s, List<String> dictionary) {
        String longest = "";

        for (String word : dictionary) {
            int i = 0, j = 0;

            while (i< s.length() && j < word.length()) {
                if(s.charAt(i) == word.charAt(j)){
                    j++;
                }
                i++;
            }

            if(j == word.length() && (word.length() > longest.length() || word.length() == longest.length() && word.compareTo(longest)  < 0)){
                longest = word;
            }
        }
        return longest;
    }
}
