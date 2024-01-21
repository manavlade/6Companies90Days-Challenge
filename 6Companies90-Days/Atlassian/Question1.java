import java.util.Arrays;
/*
 Question 1
 Assume you are an awesome parent and want to give your children some cookies. 
But, you should give each child at most one cookie. Each child i has a greed factor 
g[i], which is the minimum size of a cookie that the child will be content with; and 
each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child
i, and the child i will be content. Your goal is to maximize the number of your content
 children and output the maximum number.
 */
public class Question1 {

    public int findContentChildren(int[] g, int[] s) {
        int cookiesNums = s.length;
        if (cookiesNums == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int maxNum = 0;
        int cookieIndex = cookiesNums - 1;
        int childIndex = g.length - 1;
        while (cookieIndex >= 0 && childIndex >= 0) {
            if (s[cookieIndex] >= g[childIndex]) {
                maxNum++;
                cookieIndex--;
                childIndex--;
            } else {
                childIndex--;
            }
        }

        return maxNum;
    }
}
