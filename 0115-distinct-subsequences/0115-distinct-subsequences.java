class Solution {

   int[][] dp;

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

       dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(s, t, n, m);
    }

    public int helper(String s, String t, int i, int j) {

        
        if (j == 0) {
            return 1;
        }

        
        if (i == 0) {
            return 0;
        }

        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {

            dp[i][j] = helper(s, t, i - 1, j - 1)
                     + helper(s, t, i - 1, j);

        } else {

            dp[i][j] = helper(s, t, i - 1, j);
        }

        return dp[i][j];
    }
}