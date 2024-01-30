import java.util.Arrays;
/*
 Question 14
You are given an array trees where trees[i] = [xi, yi] represents the location of a tree
in the garden. Fence the entire garden using the minimum length of rope, as it is 
expensive. The garden is well-fenced only if all the trees are enclosed. Return the 
coordinates of trees that are exactly located on the fence perimeter. You may return
 the answer in any order.
 */
public class Question14 {
     public static int[][] outerTrees(int[][] points) 
   {
	
		Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	

		int n = points.length;
		int[][] stack = new int[2*n][];
		int s = 0;


		for (int i = 0; i < n; i++) 
        {
			while (s > 1 && cross(stack[s - 2], stack[s - 1], points[i]) > 0) 
            {
				s --;
			}
			stack[s++] = points[i];
		}
		
		for (int i = n -2 ; i >= 0; i--) 
        {
			while (s > 1 && cross(stack[s - 2], stack[s - 1], points[i]) > 0) 
            {
				s --;
			}
			stack[s++] = points[i];
		}
		
		Arrays.sort(stack, 0 , s, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));
		int m = 1;
		for (int i = 1; i < s; i ++) 
        {
			if (stack[i][0] != stack[i-1][0] || stack[i][1] != stack[i-1][1]) 
            {
				stack[m++] = stack[i];
			}
		}
		return Arrays.copyOf(stack, m);
	}

	public static int cross(int[] a, int[] b, int[] c) 
    {
		return (b[1] - a[1])*(c[0] - b[0]) - (b[0] - a[0])*(c[1] - b[1]);
	}
}
