import java.util.ArrayList;
import java.util.List;
/*
 Question 8
You are given an integer array matches where matches[i] = [winneri, loseri]
indicates that the player winneri defeated player loseri in a match.
Return a list answer of size 2 where:
answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.
Note:
You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
 */

public class Question8 {
    public List<List<Integer>> findWinners(int[][] matches) {
        int [] loses = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if(loses[win] == 0){
                loses[win]= -1;
            }
            if(loses[loss] == -1){
                loses[loss] = 1;
            }
            else{
                loses[loss]++;
            }
        }

        List<Integer> Zeroloss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();  

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < loses.length; i++) {
            if(loses[i] == -1){
                Zeroloss.add(i);
            }
            else if(loses[i] == 1){
                oneLoss.add(i);
            }
        }
        result.add(Zeroloss);
        result.add(oneLoss);

        return result;
    }

}
