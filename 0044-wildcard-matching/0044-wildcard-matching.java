class Solution {

   

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

         int[][] dp = new int[m + 1][n + 1];

       
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(m, n, s, p, dp);
    }

    public boolean helper(int i, int j, String s, String p, int[][] dp) {

       
        if (i == 0 && j == 0) {
            return true;
        }

        if (j == 0) {
            return false;
        }

       
        if (i == 0) {

            while (j > 0) {

                if (p.charAt(j - 1) != '*') {
                    return false;
                }

                j--;
            }

            return true;
        }

       
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;

      
        if (s.charAt(i - 1) == p.charAt(j - 1)
                || p.charAt(j - 1) == '?') {

            ans = helper(i - 1, j - 1, s, p, dp);
        }

        else if (p.charAt(j - 1) == '*') {

            
            ans = helper(i, j - 1, s, p, dp)
                    || helper(i - 1, j, s, p, dp);
        }

        
        else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}