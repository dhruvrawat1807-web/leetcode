class Solution {

    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        return solve(obstacleGrid, m - 1, n - 1);
    }

    int solve(int[][] grid, int i, int j) {

        // Base case: outside grid
        if (i < 0 || j < 0) {
            return 0;
        }

        // Base case: obstacle
        if (grid[i][j] == 1) {
            return 0;
        }

        // Starting point
        if (i == 0 && j == 0) {
            return 1;
        }

        // Already calculated
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // Up + Left
        dp[i][j] = solve(grid, i - 1, j)
                 + solve(grid, i, j - 1);

        return dp[i][j];
    }
}