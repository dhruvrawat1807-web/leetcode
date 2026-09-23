class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        int max = 0, ans = 0;

        for (int i = 0; i < n; i++)
            helper(i, nums, dp, count);

        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);

        for (int i = 0; i < n; i++)
            if (dp[i] == max)
                ans += count[i];

        return ans;
    }

    int helper(int i, int[] nums, int[] dp, int[] count) {
        if (dp[i] != 0)
            return dp[i];

        dp[i] = count[i] = 1;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                int len = helper(j, nums, dp, count);

                if (len + 1 > dp[i]) {
                    dp[i] = len + 1;
                    count[i] = count[j];
                } else if (len + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
        }

        return dp[i];
    }
}