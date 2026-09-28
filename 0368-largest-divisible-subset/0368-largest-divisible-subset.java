import java.util.*;

class Solution {

    int[] nums;
    int[] dp;
    int[] parent;

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        this.nums = nums;
        int n = nums.length;

        dp = new int[n];
        parent = new int[n];

        Arrays.fill(dp, -1);
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int maxIndex = 0;

        // Find the longest subset ending at every index
        for (int i = 0; i < n; i++) {
            int len = solve(i);

            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        // Reconstruct answer
        List<Integer> ans = new ArrayList<>();

        while (maxIndex != -1) {
            ans.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        return ans;
    }

    // Maximum divisible subset ending at index i
    private int solve(int i) {

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = 1;

        for (int j = 0; j < i; j++) {

            if (nums[i] % nums[j] == 0) {

                int len = solve(j) + 1;

                if (len > dp[i]) {
                    dp[i] = len;
                    parent[i] = j;
                }
            }
        }

        return dp[i];
    }
};