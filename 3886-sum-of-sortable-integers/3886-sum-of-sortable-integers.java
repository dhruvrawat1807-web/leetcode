import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n && valid; start += k) {
                int[] block = Arrays.copyOfRange(nums, start, start + k);
                int[] target = Arrays.copyOfRange(sorted, start, start + k);

                Arrays.sort(block);

                if (!Arrays.equals(block, target)) {
                    valid = false;
                    break;
                }

                int descents = 0;

                for (int i = start; i < start + k - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        descents++;
                    }
                }

                if (nums[start + k - 1] > nums[start]) {
                    descents++;
                }

                if (descents > 1) {
                    valid = false;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}