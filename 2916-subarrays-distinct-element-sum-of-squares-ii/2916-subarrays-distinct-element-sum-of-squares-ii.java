class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;

            update(1, 0, n - 1, left, i, sum, sq, lazy);

            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void apply(int node, int l, int r,
               long[] sum, long[] sq, long[] lazy, long d) {
        long len = r - l + 1;

        sq[node] = (sq[node] + 2 * d % MOD * sum[node] % MOD
                    + d * d % MOD * len % MOD) % MOD;

        sum[node] = (sum[node] + d * len) % MOD;
        lazy[node] = (lazy[node] + d) % MOD;
    }

    void push(int node, int l, int r,
              long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) / 2;
        long d = lazy[node];

        apply(node * 2, l, mid, sum, sq, lazy, d);
        apply(node * 2 + 1, mid + 1, r, sum, sq, lazy, d);

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr,
                long[] sum, long[] sq, long[] lazy) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, sum, sq, lazy, 1);
            return;
        }

        push(node, l, r, sum, sq, lazy);

        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr, sum, sq, lazy);
        update(node * 2 + 1, mid + 1, r, ql, qr, sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}