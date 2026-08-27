class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int m = a.length, n = b.length;
        int l = 0, r = m;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            int l1 = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int r1 = i == m ? Integer.MAX_VALUE : a[i];

            int l2 = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int r2 = j == n ? Integer.MAX_VALUE : b[j];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1)
                    return Math.max(l1, l2);

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if (l1 > r2)
                r = i - 1;
            else
                l = i + 1;
        }

        return 0;
    }
}