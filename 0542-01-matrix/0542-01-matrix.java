
import java.util.*;

class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } 
                else {
                    dist[i][j] = -1;
                }
            }
        }

        // 4 directions
        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

               
                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n &&
                    dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }
}
