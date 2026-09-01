class Solution {
    public int rob(int[] n) {
        int[] dp = new int[n.length];
        Arrays.fill(dp, -1);

        return solve(n, n.length-1, dp);
    }

    public int solve(int[] n, int i, int[] dp) {

       
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int rob = n[i] + solve(n, i - 2, dp);
        int skip = solve(n, i - 1, dp);

        return dp[i] = Math.max(rob, skip);
    }
}