class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];

        Arrays.fill(dp, -2);
        int ans = solve(coins, amount, dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public int solve(int[] coins, int amount, int[] dp){

        if(amount == 0){
        return 0;
        }

        if(amount < 0){
        return Integer.MAX_VALUE;
        }

        if(dp[amount] != -2){
        return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = solve(coins, amount - coin, dp);

            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, result + 1);
            }
        }

        dp[amount] = min;

        return min;
    }

}