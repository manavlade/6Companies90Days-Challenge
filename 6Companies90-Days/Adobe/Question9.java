import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 Question 9
 A cinema has n rows of seats, numbered from 1 to n and there are
  ten seats in each row, labelled from 1 to 10 as shown in the figure above.
Given the array reservedSeats containing the numbers of seats already 
reserved, for example, reservedSeats[i] = [3,8] means the seat located in row
3 and labelled with 8 is already reserved.
Return the maximum number of four-person groups you can assign on the 
cinema seats. A four-person group occupies four adjacent seats in one single row. 
Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent,
 but there is an exceptional case on which an aisle split a four-person group,
in that case, the aisle split a four-person group in the middle, which means to
 have two people on each side.
 */

public class Question9 {
   
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<String>> blocked = new HashMap<>();

        for (int[] reservation : reservedSeats) {
            int row = reservation[0];
            int col = reservation[1];

            if (col == 1 || col == 10) {
                continue;
            }

            Set<String> set = blocked.computeIfAbsent(row, k -> new HashSet<>());

            if (col >= 2 && col <= 5) {
                set.add("left");
            }
            if (col >= 4 && col <= 7) {
                set.add("middle");
            }
            if (col >= 6 && col <= 9) {
                set.add("right");
            }
        }
        int total = 2 * (n - blocked.size());

        int[] numAvailable = {
            2,
            1, 
            1, 
            0  
        };
        for (Set<String> blocks : blocked.values()) {
            total += numAvailable[blocks.size()];
        }
        
        return total;
    }
}
