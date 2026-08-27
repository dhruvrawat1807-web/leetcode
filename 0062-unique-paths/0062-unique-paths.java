class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        return solve(m - 1, n - 1);
    }

    int solve(int i, int j) {

        
        if (i == 0 || j == 0) {
            return 1;
        }

        
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // Up + Left
        dp[i][j] = solve(i - 1, j) + solve(i, j - 1);

        return dp[i][j];
    }
}