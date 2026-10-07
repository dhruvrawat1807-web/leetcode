class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(s);
        vis.add(s);
        boolean found = false;

        while (!q.isEmpty() && !found) {
            int n = q.size();

            while (n-- > 0) {
                String cur = q.poll();

                if (valid(cur)) {
                    ans.add(cur);
                    found = true;
                    continue;
                }

                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        String next = cur.substring(0, i) + cur.substring(i + 1);

                        if (vis.add(next))
                            q.add(next);
                    }
                }
            }
        }
        return ans;
    }

    boolean valid(String s) {
        int bal = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') bal++;
            else if (c == ')' && --bal < 0) return false;
        }

        return bal == 0;
    }
}