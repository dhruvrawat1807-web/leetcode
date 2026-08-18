class Solution {

    public boolean search(int[][] a, int i, int j, int target) {

        if (i == a.length) {
            return false;
        }

        if (j == a[0].length) {
            return search(a, i + 1, 0, target);
        }

        if (a[i][j] == target) {
            return true;
        }

        return search(a, i, j + 1, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, 0, target);
    }
}