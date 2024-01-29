/*
 Question 6
 You are given an m x n binary grid grid where 1 represents land and 0 represents water.
An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.
The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
In one day, we are allowed to change any single land cell (1) into a water cell (0).
Return the minimum number of days to disconnect the grid.
 */
public class Question6 {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int isLandCount = 0;
        for(int i =0; i < m; i++)
        for (int j = 0; j < n; j++)   
            if (grid[i][j] == 1 && !visited[i][j]) {
                isLandCount++;
                countIsLand(i, j, grid, visited, m, n);
            }
            if(isLandCount > 1){
                return 0;
            }
            int onesCount =0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        onesCount++;
                        grid[i][j]= 0;

                        if(checkIsLand(grid) > 1){
                            return 1;
                        }
                        grid[i][j] = 1;
                    }
                 }
            }
            return (onesCount == 0) ? 0 : (onesCount == 1) ? 1 : 2;
    }

    public int checkIsLand(int[][] grid){
        int isLandCount = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    isLandCount++;
                    countIsLand(i, j, grid, visited, m, n);
                }
            }
        }
        return isLandCount;
    }

    public void countIsLand(int r, int c, int[][] grid, boolean[][] visited, int m, int n) {
        visited[r][c] = true;
        int arr1[] = { 0, 0, -1, 1 };
        int arr2[] = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int nr = r + arr1[i];
            int nc = c + arr2[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc])
                countIsLand(nr, nc, grid, visited, m, n);

        }
    }
}
