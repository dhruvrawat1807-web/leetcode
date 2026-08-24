import java.util.*;

class Solution {
    Map<Integer, Integer> freq = new HashMap<>();

    public int[] frequencySort(int[] nums) {
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        sort(nums, nums.length - 1);

        return nums;
    }

    void sort(int[] nums, int n) {
        if (n <= 0)
            return;

        sort(nums, n - 1);

        int x = nums[n];
        int j = n - 1;

        while (j >= 0 && better(nums[j], x)) {
            nums[j + 1] = nums[j];
            j--;
        }

        nums[j + 1] = x;
    }

    boolean better(int a, int b) {
        if (!freq.get(a).equals(freq.get(b)))
            return freq.get(a) > freq.get(b);

        return a < b;
    }
}