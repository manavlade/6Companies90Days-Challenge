import javax.swing.tree.TreeNode;

/*
 Question 12
You are given the root of a binary tree and an integer distance. A pair of two different
leaf nodes of a binary tree is said to be good if the length of the shortest path 
between them is less than or equal to distance. Return the number of good leaf node pairs in the tree.
 */
public class Question12{
    
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    
    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }
        
        return res;
    }
}
