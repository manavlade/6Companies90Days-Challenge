/* 
Question 1
We have two arrays arr1 and arr2 which are initially empty. You need to add positive integers to them such that they satisfy all the following conditions:
arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
No integer is present in both arr1 and arr2.
Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array.*/

public class GoldmanSachs {
    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a% b);
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
 Question 2
You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.
The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".
An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.
Times with exactly one hour of difference are not considered part of the same one-hour period. For example, "0815" and "0915" are not part of the same one-hour period.
Access times at the start and end of the day are not counted within the same one-hour period. For example, "0005" and "2350" are not part of the same one-hour period.
Return a list that contains the names of high-access employees with any order you want.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
