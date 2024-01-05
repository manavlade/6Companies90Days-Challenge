import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.Collections;
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

public class GoldmanSachs {
  int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    long l = 1, r = (int) (2 * 1e9);
    long ans = r;
    long lcm = (1L * divisor1 * divisor2) / gcd(divisor1, divisor2);
    for (; l <= r;) {
      long mid = (l + r) >> 1;
      long x = mid - mid / divisor1;
      long y = mid - mid / divisor2;
      long z = mid - mid / lcm;
      if (x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2))
        l = mid + 1;
      else {
        ans = Math.min(ans, mid);
        r = mid - 1;
      }
    }
    return (int) ans;
  }
}

/*
 * Question 2
 * You are given a 2D 0-indexed array of strings, access_times, with size n. For
 * each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an
 * employee, and access_times[i][1] represents the access time of that employee.
 * All entries in access_times are within the same day.
 * The access time is represented as four digits using a 24-hour time format,
 * for example, "0800" or "2250".
 * An employee is said to be high-access if he has accessed the system three or
 * more times within a one-hour period.
 * Times with exactly one hour of difference are not considered part of the same
 * one-hour period. For example, "0815" and "0915" are not part of the same
 * one-hour period.
 * Access times at the start and end of the day are not counted within the same
 * one-hour period. For example, "0005" and "2350" are not part of the same
 * one-hour period.
 * Return a list that contains the names of high-access employees with any order
 * you want.
 */

public class GoldmanSachs {
  public List<String> findHighAccessEmployees(List<List<String>> access_times) {
    java.util.Map<String, List<Integer>> map = new HashMap<>();
    for (List<String> timing : access_times) {
      String name = timing.get(0);
      int t = Integer.parseInt(timing.get(1));
      map.putIfAbsent(name, new ArrayList<>());
      map.get(name).add(t);
    }
    List<String> res = new ArrayList<>();
    for (String name : map.keySet()) {
      List<Integer> times = map.get(name);
      Collections.sort(times);
      for (int i = 0; i < times.size() - 2; i++) {
        if (times.get(i + 2) - times.get(i) < 100) {
          res.add(name);
          break;
        }
      }
    }
    return res;

  }
}

/*
 * Question 3
 * You are given a 0-indexed array of strings nums, where each string is of
 * equal length and
 * consists of only digits. You are also given a 0-indexed 2D integer array
 * queries where queries[i] = [ki, trimi]. For each queries[i], you need to:
 * Trim each number in nums to its rightmost trimi digits.
 * Determine the index of the kith smallest trimmed number in nums. If two
 * trimmed numbers are equal, the number with the lower index is considered to
 * be smaller.
 * Reset each number in nums to its original length.
 * Return an array answer of the same length as queries, where answer[i] is the
 * answer to the ith query.
 * Note:
 * To trim to the rightmost x digits means to keep removing the leftmost digit,
 * until only x digits remain.
 * Strings in nums may contain leading zeros.
 */

class Node {
  int index;
  String val;

Node(int i, String V){
this.index = i;
this.val = V;
}

}

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


/*
 Question 4
 Find all valid combinations of k numbers that sum up to n such that the following 
 conditions are true: Only numbers 1 through 9 are used. Each number is used at most once.
Return a list of all possible valid combinations. The list must
 not contain the same combination twice, and the combinations may be returned in any order.
 */

public class GoldmanSachs {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> current = new ArrayList<>();
       backTrack(result, current, k, n, 1);
       return result; 
    }

    private void backTrack(List<List<Integer>> result,List<Integer> 
    current, int k, int target, int start){
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backTrack(result, current, k, target -i, i +1);
            current.remove(current.size()-1);
        }

    }
}

/*
 Question 5
 There is an m x n binary grid matrix with all the values set 0 initially. Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1.
  All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.
Optimize your algorithm to minimize the number of calls made to the built-in random function of your language and optimize the time and space complexity.
Implement the Solution class:
Solution(int m, int n) Initializes the object with the size of the binary matrix m and n.
int[] flip() Returns a random index [i, j] of the matrix where matrix[i][j] == 0 and flips it to 1.
void reset() Resets all the values of the matrix to be 0.
 */


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
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
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


public class GoldmanSachs {
  private int value, k, count;

  public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

  public boolean consec(int num) {
    if(value == num) {
      ++count;
    }
    else {
      count=0;
    }
    return count >=k;
  }
 }

/*
Question 9
Given a pattern containing only I's and D's. 
I for increasing and D for decreasing. 
Devise an algorithm to print the minimum number following that pattern.
 Digits from 1-9 and digits can't repeat.
 */

public class GoldmanSachs {
  static String printMinNumberForPattern(String S) 
  {
    StringBuilder result = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int n = S.length();
    for (int i = 0; i <= n; i++) {
      stack.push(i+1);
      if(i == n || S.charAt(i) == 'I'){
        while (!stack.isEmpty()) {
          result.append(stack.pop());
        }
      }
    }
    return result.toString();
  }

}

/*
 Question 10
 Given an integer array nums and two integers k and p, return the number of distinct subarrays, 
 which have at most k elements that are divisible by p. Two arrays nums1 and nums2 are said to be distinct if:
They are of different lengths, or There exists at least one index i where nums1[i] != nums2[i].
A subarray is defined as a non-empty contiguous sequence of elements in an array.
 */

 public class GoldmanSachs {
     public int countDistinct(int[] nums, int k, int p) 
     {
        int n = nums.length;
        Set<Long> waysArray = new HashSet<>();
        for (int i = 0; i < n; i++) {
          int count = 0;
          long hc = 1;
          for (int j = i; j < n; j++) {
            hc = 199L * hc + nums[j];

            if(nums[j] % p == 0){
              count++;
            }
            if(count <= k){
              waysArray.add(hc);
            }
          }
        }
        return waysArray.size();
    }
 }

 /*
  Question 11
  You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:
The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.
Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
  */

  public class GoldmanSachs{
      private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            
            for (int[] direction : DIRECTIONS) {
                int ni = i + direction[0], nj = j + direction[1];

                
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && height[ni][nj] == -1) {
                    height[ni][nj] = height[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }

        return height;
    }
  }
 /*
  Question 12
  Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.
  */

public class GoldmanSachs {
  String encode(String str)
    {
          int l = 0;
          
          int r = 0;
          
          StringBuilder sb = new StringBuilder();
          
          while(r < str.length()){
              
              l = r;
              
              while(r < str.length() && str.charAt(r) == str.charAt(l))
               r++;
              
               sb.append(str.charAt(l)).append(r-l);
          }
         return sb.toString();
    }
}

/*
 Question 13
 Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

 public class GoldmanSachs {
 int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private int[] postOrder(TreeNode node) {
        if (node == null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int[] curr = new int[4];
        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            curr[0] = 1;
            curr[1] = Math.min(left[1], node.val);
            curr[2] = Math.max(right[2], node.val);
            curr[3] = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, curr[3]);
        } else {
            curr[0] = 0;
            curr[3] = 0; 
        }
        return curr;
    }  
 }