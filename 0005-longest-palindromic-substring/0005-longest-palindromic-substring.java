class Solution {
    String[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new String[n][n];
        return solve(s, 0, n - 1);
    }

    String solve(String s, int l, int r) {
        if (l > r) return "";

        if (dp[l][r] != null)
            return dp[l][r];

        if (isPal(s, l, r))
            return dp[l][r] = s.substring(l, r + 1);

        String a = solve(s, l + 1, r);
        String b = solve(s, l, r - 1);

        return dp[l][r] =
            a.length() >= b.length() ? a : b;
    }

    boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}