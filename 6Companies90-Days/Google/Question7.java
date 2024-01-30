/*
 Question 7
You are building a string s of length n one character at a time, prepending each new
character to the front of the string. The strings are labeled from 1 to n, where the
string with length i is labeled si.
For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
The score of si is the length of the longest common prefix between si and sn (Note that s == sn).
Given the final string s, return the sum of the score of every si.
 */
public class Question7 {
    public int[] calculateZ(char [] input){
        int [] z = new int[input.length];
        int left = 0, right = 0;

        for (int i = 0; i < input.length; i++) {
            if(i > right){
                left = right = i;
                while (right < input.length && input[right] == input[right-left]) {
                    right++;
                }
                z[i] = right - left;
                right--;
            }
            else{
                int k = i - left;
                if(z[k] < right -i +1){
                    z[i] = z[k];
                }
                else {
                    left = i;
                    while (right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        return z;
    }
    
    public long sumScores(String s) {
        int[] z = calculateZ(s.toCharArray());

        long sum = 0;
        for (int el : z)
            sum += el;
        sum += s.length();
        return sum;
    }

}
