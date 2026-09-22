class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, amount, coins, dp);
    }

    public int helper(int index, int amount, int[] coins, int[][] dp){

        if(amount == 0)
        return 1;

        if(index == coins.length)
        return 0;

        if(dp[index][amount] != -1)
        return dp[index][amount];

        int ways = 0;

        if(coins[index] <= amount){
             ways = helper(index, amount - coins[index], coins, dp);
        }

        ways += helper(index + 1, amount, coins, dp);

        dp[index][amount] = ways;

        return ways;
    }
}