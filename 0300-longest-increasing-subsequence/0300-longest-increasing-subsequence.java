class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];

        int answer = 0;

        for(int i = 0; i < n; i++){

            answer = Math.max(answer, helper(i, nums, dp));
        }
        return answer;
    }

    public int helper(int i, int[] nums, int[] dp){
        int ans = 1;

        if(dp[i] != 0)
        return dp[i];

        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] < nums[j]){
                ans = Math.max(ans, 1 + helper(j, nums, dp));
            }
        }

        return dp[i] = ans;
    }
}