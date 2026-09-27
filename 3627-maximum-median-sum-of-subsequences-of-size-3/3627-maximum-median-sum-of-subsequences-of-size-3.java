import java.util.Arrays;

class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int k = n / 3;

        long sum = 0;

        int index = n - 2;

        for (int i = 0; i < k; i++) {
            sum += nums[index];
            index -= 2;
        }

        return sum;
    }
}