/*
 Question 1
 You are given a circle represented as (radius, xCenter, yCenter) and an axis-aligned rectangle represented as (x1, y1, x2, y2), where (x1, y1)
are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the rectangle.
Return true if the circle and rectangle are overlapped otherwise return false. In other words, check if
 there is any point (xi, yi) that belongs to the circle and the rectangle at the same time.
 */

public class Question1 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                double distance = (i - xCenter) * (i - xCenter) + (j - yCenter) * (j - yCenter);
                double r = radius * radius;
                if (distance <= r) {
                    return true;
                }
            }
        }
        return false;
    }
}