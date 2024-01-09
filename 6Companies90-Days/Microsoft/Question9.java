/*
 Question 9
 The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.
Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question9 {
        public List<String> findRepeatedDnaSequences(String s) {
        List<String> dNa = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length()-10; i++) {
            String sequence = s.substring(i, i+10);

            if(seen.contains(sequence)){
                repeated.add(sequence);
            }
            else {
                seen.add(sequence);
            }
        }
        dNa.addAll(repeated);
        return dNa;
   }

}
