/*
 Question 7
 There are n persons on a social media website. You are given an integer array 
 ages where ages[i] is the age of the ith person. A Person x will not send a friend request to a 
 person y (x != y) if any of the following conditions is true:
age[y] <= 0.5 * age[x] + 7
age[y] > age[x]
age[y] > 100 && age[x] < 100
Otherwise, x will send a friend request to y.
Note that if x sends a request to y, y will not necessarily send a request to x. 
Also, a person will not send a friend request to themself.
Return the total number of friend requests made.
 */
public class Question7 {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];


        for (int a : ages) {
            numInAge[a]++;
        }

        
        for (int i = 1; i <= 120; i++) {
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        }

       
        for (int i = 15; i <= 120; i++) {
            if (numInAge[i] == 0)
                continue;
            int c = sumInAge[i] - sumInAge[i / 2 + 7];
            res += c * numInAge[i] - numInAge[i];
        }

        return res;
    }
}

