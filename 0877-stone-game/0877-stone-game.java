class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(piles, 0, n-1, dp) > 0;
    }

    public int solve(int[] piles, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int left = piles[i] - solve(piles, i+1, j, dp);

        int right = piles[i] - solve(piles, i, j-1, dp);

        dp[i][j] = Math.max(left, right);

        return dp[i][j];
    }
}