
import java.util.*;

class Solution {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        

        for (int i = 0; i < m; i++) {
            bfs(grid, i, 0);
            bfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            bfs(grid, 0, j);
            bfs(grid, m - 1, j);
        }

       

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    void bfs(int[][] grid, int row, int col) {

        int m = grid.length;
        int n = grid[0].length;

      
        if (row < 0 || col < 0 ||
            row >= m || col >= n ||
            grid[row][col] == 1) {
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{row, col});

        
        grid[row][col] = 1;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
