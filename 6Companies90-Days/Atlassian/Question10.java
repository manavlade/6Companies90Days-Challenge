import java.util.Arrays;
import java.util.HashMap;

/*
 Question 10
 You are given a 0-indexed array of strings nums, where each string is of equal length 
and consists of only digits. You are also given a 0-indexed 2D integer array queries 
where queries[i] = [ki, trimi]. For each queries[i], you need to:
Trim each number in nums to its rightmost trimi digits. Determine the index of the kith
 smallest trimmed number in nums. If two trimmed numbers are equal, the number with the lower index is considered to be smaller.
Reset each number in nums to its original length. Return an array answer of the same 
length as queries, where answer[i] is the answer to the ith query.
Note:
To trim to the rightmost x digits means to keep removing the leftmost digit, until only x digits remain.
Strings in nums may contain leading zeros.
 */
public class Question10 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer, Node[]> map = new HashMap<>();
        int[] res = new int[queries.length];
        int idx = 0, len = nums[0].length();

        for (int[] query : queries) {
            if (!map.containsKey(query[1])) {
                Node[] arr = new Node[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    String x = nums[i].substring(len - query[1], len);
                    arr[i] = new Node(i, x);
                }
                Arrays.sort(arr, (a, b) -> a.val.compareTo(b.val));
                map.put(query[1], arr);
            }
            res[idx++] = map.get(query[1])[query[0] - 1].index;
        }

        return res;
    }

    class Node {
        int index;
        String val;

        Node(int i, String v) {
            this.index = i;
            this.val = v;
        }
}
}
