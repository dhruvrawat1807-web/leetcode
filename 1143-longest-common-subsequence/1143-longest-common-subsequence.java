class Solution {

     int [][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(text1, text2, m-1, n-1);
    }

    public int helper(String text1, String text2, int i, int j) {
        if(i < 0 || j < 0)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + helper(text1, text2, i-1, j-1);
        }
        else{
            dp[i][j] = Math.max(helper(text1, text2, i-1, j), helper(text1, text2, i, j-1));
        }
        return dp[i][j];
}
}