
import java.util.Arrays;

class Solution {
   

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, k, nums, dp);
    }

    public int solve(int i, int k, int[] nums, int[][] dp) {
        int n = nums.length;

        if (k == 1) {
            int sum = 0;

            for (int t = i; t < n; t++) {
                sum += nums[t];
            }

            return sum;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int currSum = 0;
        int result = Integer.MAX_VALUE;

        for (int j = i; j <= n - k; j++) {
            currSum += nums[j];

            int remSum = solve(j + 1, k - 1, nums, dp);

            int largeSum = Math.max(currSum, remSum);

            result = Math.min(result, largeSum);
        }

        return dp[i][k] = result;
    }
}
