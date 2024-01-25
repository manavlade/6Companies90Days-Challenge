/*
 Question 12
 Given two integer arrays arr1 and arr2, and the integer d, return the distance value
between the two arrays. The distance value is defined as the number of elements arr1[i]
 such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 */
public class Question12 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            if(find(arr2, arr1[i], d)){
                result++;
            }
        }
        return result;
    }
    
    private  boolean find(int [] arr, int j, int d){
        for (int i = 0; i < arr.length; i++) {
            int calculation = j - arr[i];
            if(Math.abs(calculation) <= d){
                return false;
            }
        }
        return true;
    }

}
