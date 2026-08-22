class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int n = x, r = 0;
        while (n > 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }

        return x == r;
    }
}