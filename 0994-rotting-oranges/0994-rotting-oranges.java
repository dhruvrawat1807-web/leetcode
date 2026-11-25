
import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;

                        fresh--;

                        q.add(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
