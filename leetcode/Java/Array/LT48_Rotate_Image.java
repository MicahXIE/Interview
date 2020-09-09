class Solution {  // 0ms 100% *
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        int h = matrix.length;
        int w = matrix[0].length;
        int temp;
        // matrix diagnal flip
        for (int i = 0; i < h - 1; ++i) {
            for (int j = i + 1; j < w; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // matrix symertrical flip
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < (w / 2); ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][w - j - 1];
                matrix[i][w - j - 1] = temp;
            }
        }
        return;
    }
}