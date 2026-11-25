
import java.util.*;

class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Check first and last column
        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }

        // Check first and last row
        for (int j = 0; j < n; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }

        // Convert remaining O to X
        // Restore safe cells from # to O

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void bfs(char[][] board, int row, int col) {

        int m = board.length;
        int n = board[0].length;

        if (row < 0 || col < 0 ||
            row >= m || col >= n ||
            board[row][col] != 'O') {
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{row, col});

        // Mark visited
        board[row][col] = '#';

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
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';

                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
