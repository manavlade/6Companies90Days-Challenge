/*
 Question 11
 We have a wooden plank of the length n units. Some ants are walking on the plank, 
 each ant moves with a speed of 1 unit per second. Some of the ants move to the left, 
 the other move to the right. When two ants moving in two different directions meet at
  some point, they change their directions and continue moving again. Assume changing 
  directions does not take any additional time. When an ant reaches one end of the plank
 at a time t, it falls out of the plank immediately. Given an integer n and two integer 
 arrays left and right, the positions of the ants moving to the left and the right, return
  the moment when the last ant(s) fall out of the plank.
 */
public class Question11 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MAX_VALUE;

        for (int i = 0; i < left.length; i++) {
            if(leftMax < left[i]){
                leftMax = left[i];
            }
        }
        for (int i = 0; i < right.length; i++) {
            if(rightMax > right[i]){
                rightMax = right[i];
            }
        }

        return Math.max(leftMax, n - rightMax);
    }

}
