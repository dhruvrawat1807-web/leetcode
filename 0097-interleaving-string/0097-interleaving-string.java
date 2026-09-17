class Solution {

   

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

         int[][] dp = new int[m + 1][n + 1];

       
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(s1, s2, s3, 0, 0, dp);
    }

    private boolean helper(String s1, String s2, String s3,
                           int i, int j, int[][] dp) {

       
        if (i + j == s3.length()) {
            return true;
        }

       
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        int k = i + j;

        boolean ans = false;

       
        if (i < s1.length() &&
            s1.charAt(i) == s3.charAt(k)) {

            ans = helper(s1, s2, s3, i + 1, j, dp);
        }

       
        if (!ans &&
            j < s2.length() &&
            s2.charAt(j) == s3.charAt(k)) {

            ans = helper(s1, s2, s3, i, j + 1, dp);
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}