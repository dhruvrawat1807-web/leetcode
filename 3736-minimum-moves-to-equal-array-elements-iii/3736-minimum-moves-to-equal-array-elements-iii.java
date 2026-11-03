
class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        
        //  maximum element nikaalne k liye
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        int moves = 0;
        
        //  total moves calculaate krne k liye
        for (int i = 0; i < nums.length; i++) {
            moves += max - nums[i];
        }
        
        return moves;
    }
}
