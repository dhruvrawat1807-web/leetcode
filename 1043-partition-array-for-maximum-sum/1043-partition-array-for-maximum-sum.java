class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        return solve(0, arr, k);
    }
    public int solve(int i, int[] arr, int k){
        if(i >= arr.length)
        return 0;

        int maxNum = -1;
        int len = 0;
        int result = 0;

        for(int j = i; j < arr.length && j < i+k; j++){
            maxNum = Math.max(maxNum, arr[j]);
            len = j-i+1;

            int cost = maxNum * len + solve(j+1, arr, k);
            result = Math.max(result, cost);
        }
        return result;
    }
}