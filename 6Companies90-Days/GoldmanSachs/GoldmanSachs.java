/*
 * Question 1
 * We have two arrays arr1 and arr2 which are initially empty. You need to add
 * positive integers to them such that they satisfy all the following
 * conditions:
 * arr1 contains uniqueCnt1 distinct positive integers, each of which is not
 * divisible by divisor1.
 * arr2 contains uniqueCnt2 distinct positive integers, each of which is not
 * divisible by divisor2.
 * No integer is present in both arr1 and arr2.
 * Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum
 * possible maximum integer that can be present in either array.
 */
// public class GoldmanSachs {
// int gcd(int a, int b){
// return b == 0 ? a : gcd(b, a% b);
// }

// public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int
// uniqueCnt2) {
// long l = 1, r = (int) (2 * 1e9);
// long ans = r;
// long lcm = (1L * divisor1 * divisor2) / gcd(divisor1, divisor2);
// for (; l <= r;) {
// long mid = (l + r) >> 1;
// long x = mid - mid / divisor1;
// long y = mid - mid / divisor2;
// long z = mid - mid / lcm;
// if (x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 +
// uniqueCnt2))
// l = mid + 1;
// else {
// ans = Math.min(ans, mid);
// r = mid - 1;
// }
// }
// return (int) ans;
// }
// }

/*
 * Question 2
 * You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.

The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".

An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.

Times with exactly one hour of difference are not considered part of the same one-hour period. For example, "0815" and "0915" are not part of the same one-hour period.

Access times at the start and end of the day are not counted within the same one-hour period. For example, "0005" and "2350" are not part of the same one-hour period.

Return a list that contains the names of high-access employees with any order you want.
 */

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// public class GoldmanSachs {
// public List<String> findHighAccessEmployees(List<List<String>> access_times)
// {
// java.util.Map<String, List<Integer>> map = new HashMap<>();
// for (List<String> timing : access_times) {
// String name = timing.get(0);
// int t = Integer.parseInt(timing.get(1));
// map.putIfAbsent(name, new ArrayList<>());
// map.get(name).add(t);
// }
// List<String> res = new ArrayList<>();
// for (String name : map.keySet()) {
// List<Integer> times = map.get(name);
// Collections.sort(times);
// for (int i = 0; i < times.size() - 2; i++) {
// if (times.get(i + 2) - times.get(i) < 100) {
// res.add(name);
// break;
// }
// }
// }
// return res;

// }
// }

/*
 * Question 3
 You are given a 0-indexed array of strings nums, where each string is of equal length and
  consists of only digits. You are also given a 0-indexed 2D integer array queries where queries[i] = [ki, trimi]. For each queries[i], you need to:
Trim each number in nums to its rightmost trimi digits.
Determine the index of the kith smallest trimmed number in nums. If two trimmed numbers are equal, the number with the lower index is considered to be smaller.
Reset each number in nums to its original length.
Return an array answer of the same length as queries, where answer[i] is the answer to the ith query.
Note:
To trim to the rightmost x digits means to keep removing the leftmost digit, until only x digits remain.
Strings in nums may contain leading zeros.
 */

// class Node {
// int index;
// String val;

// Node(int i, String V){
// this.index = i;
// this.val = V;
// }
// }

// public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
// HashMap<Integer, Node[]> map = new HashMap<>();
// int[] res = new int[queries.length];
// int idx = 0, len = nums[0].length();

// for (int[] query : queries) {
// if (!map.containsKey(query[1])) {
// Node[] arr = new Node[nums.length];
// for (int i = 0; i < nums.length; i++) {
// String x = nums[i].substring(len - query[1], len);
// arr[i] = new Node(i, x);
// }
// Arrays.sort(arr, (a, b) -> a.val.compareTo(b.val));
// map.put(query[1], arr);
// }
// res[idx++] = map.get(query[1])[query[0] - 1].index;
// }

// return res;
// 

/*
 Question 4
 Find all valid combinations of k numbers that sum up to n such that the following 
 conditions are true: Only numbers 1 through 9 are used. Each number is used at most once.
Return a list of all possible valid combinations. The list must
 not contain the same combination twice, and the combinations may be returned in any order.
 */

// import java.util.ArrayList;
// import java.util.List;

// public class GoldmanSachs {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        backTrack(result, current, k, n, 1);
//        return result; 
//     }

//     private void backTrack(List<List<Integer>> result,List<Integer> 
//     current, int k, int target, int start){
//         if (target == 0 && current.size() == k) {
//             result.add(new ArrayList<>(current));
//             return;
//         }
//         for (int i = start; i <= 9; i++) {
//             current.add(i);
//             backTrack(result, current, k, target -i, i +1);
//             current.remove(current.size()-1);
//         }

//     }
// }

/*
 Question 5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GoldmanSachs {
int rows;
int colums;
int total;
Random random;
Map<Integer, Integer> map;

public Solution(int m , int n){
    rows = m;
    colums = n;
    total = m * n;
    random = new Random();
    map = new HashMap<>();
}
public int[] flip() {
    int r = random.nextInt(total--);
    int x = map.getOrDefault(r, r);
    map.put(r, map.getOrDefault(total, total));
    return new int[]{x / colums, x % colums};
}
public void reset() {
    map.clear();
    total = rows * colums;
}
}

/*
 Question 6

 */

public class GoldmanSachs {

   public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        String[] mapping = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backTrack(result, "", digits, mapping, 0);
        return result;
    }

    private void backTrack(List<String> result, String current, String digits, String[] mapping, int indx) {
      if(indx == digits.length()){
        result.add(current);
        return;
      }
      String letters = mapping[digits.charAt(indx) - '2'];
      for (int i = 0; i < letters.length(); i++) {
        backTrack(result, current + letters.charAt(i), digits, mapping, indx +1);
      }
    }
}

/*
 Question 7
 Given an unsorted array Arr of size N of positive integers.
  One number 'A' from set {1, 2,....,N} is missing and one number 
 'B' occurs twice in array. Find these two numbers.
 */

public class GoldmanSachs {
  int[] findTwoElement(int arr[], int n) {
    int repeating = 0;
    int missing = 0;
    for (int i = 0; i < n; i++) {
      int index = Math.abs(arr[i]) - 1;
      if(arr[index] > 0){
        arr[index] = -arr[index];
      }
      else {
        repeating = Math.abs(arr[i]);
      }
    }
    for (int i = 0; i < n; i++) {
      if(arr[i] > 0){
        missing = i+1;
        break;
      }
    }
    return new int[]{repeating, missing};
  }
}

/*
 Question 8
 For a stream of integers, implement a data structure that checks if the last k 
 integers parsed in the stream are equal to value. Implement the DataStream class:
DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise. 
If there are less than k integers, the condition does not hold true, so returns false.
 */

// public class GoldmanSachs {
//   private int value, k, count;
  
//   public DataStream(int value, int k) {
//         this.value = value;
//         this.k = k;
//     }

//   public boolean consec(int num) {
//     if(value == num) {
//       ++count;
//     }
//     else {
//       count=0;
//     }
//     return count >=k;
//   }
//  }