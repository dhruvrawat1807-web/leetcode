import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int[][] dp = new int[nums.length][2 * sum + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, 0, target, dp, sum);
    }

    public int solve(int[] nums, int i, int curr, int target,
                     int[][] dp, int offset) {

        if (i == nums.length) {
            if (curr == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int index = curr + offset;

        if (dp[i][index] != -1) {
            return dp[i][index];
        }

        int positive = solve(nums, i + 1, curr + nums[i],
                             target, dp, offset);

        int negative = solve(nums, i + 1, curr - nums[i],
                             target, dp, offset);

        dp[i][index] = positive + negative;

        return dp[i][index];
    }
}