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
