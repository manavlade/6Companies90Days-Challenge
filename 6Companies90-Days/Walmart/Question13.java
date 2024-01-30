import javax.swing.tree.TreeNode;
/*
 Question 13
 You are given the root of a binary tree with unique values, and an integer start. 
At minute 0, an infection starts from the node with value start.
Each minute, a node becomes infected if:
The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.
 */
public class Question13 {
    	public static int maxLength(TreeNode node) {
		int lc = node.left == null ? 0 : maxLength(node.left) + 1;
		int rc = node.right == null ? 0 : maxLength(node.right) + 1;
		return lc > rc ? lc : rc;
	}

    static final int[] EMPTY_NODE = new int[] {0, -1};
    static int times = 0;
	
	public static int countToStart(TreeNode node, int startVal) {
		if (node.val == startVal) {
            times = maxLength(node);
			return -1;
		}

        if (node.left == null && node.right == null)
            return 1;

        int lc = node.left == null ? 0 : countToStart(node.left, startVal);
        int rc = node.right == null ? 0 : countToStart(node.right, startVal);
        if (lc < 0) {
            times = Math.max(times, rc - lc);
            return lc - 1;
        } else if (rc < 0) {
            times = Math.max(times, lc - rc);
            return rc - 1;
        } else
            return Math.max(lc, rc) + 1;
	}

    public int amountOfTime(TreeNode root, int start) {
		countToStart(root, start);
        return times;
    }
}
