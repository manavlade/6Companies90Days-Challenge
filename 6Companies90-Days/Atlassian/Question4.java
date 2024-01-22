import java.util.Arrays;
/*
 Question 4
There is a grid with n + 2 horizontal bars and m + 2 vertical bars, 
and initially containing 1 x 1 unit cells.
The bars are 1-indexed. You are given the two integers, n and m.
You are also given two integer arrays: hBars and vBars.
hBars contains distinct horizontal bars in the range [2, n + 1].
vBars contains distinct vertical bars in the range [2, m + 1].
You are allowed to remove bars that satisfy any of the following conditions:
If it is a horizontal bar, it must correspond to a value in hBars.
If it is a vertical bar, it must correspond to a value in vBars.
Return an integer denoting the maximum area of a square-shaped hole in the
 grid after removing some bars (possibly none).
 */
public class Question4 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = find(hBars), y = find(vBars);
        int res = Math.min(x, y) + 1;
        return res * res;
    }

    private int find(int [] arr){
        Arrays.sort(arr);
        int res = 1;

        for (int i = 0; i < arr.length;) {
            int count = 1;

            while (i+1 < arr.length && arr[i] + 1 == arr[i+1]) {
                i++;
                count++;
            }
            i++;
            res = Math.max(res, count);
        }
        return res;
    }
}
