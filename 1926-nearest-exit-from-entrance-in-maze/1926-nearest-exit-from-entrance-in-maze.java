class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});

        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int size = q.size();
            steps++;

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                for (int[] d : dir) {

                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r < 0 || r >= n || c < 0 || c >= m)
                        continue;

                    if (maze[r][c] == '+')
                        continue;

                    if (r == 0 || r == n - 1 || c == 0 || c == m - 1)
                        return steps;

                    maze[r][c] = '+';
                    q.add(new int[]{r, c});
                }
            }
        }

        return -1;
    }
}