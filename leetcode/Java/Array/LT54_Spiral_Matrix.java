class Solution {  // 0ms 100% time O(mn) space O(mn)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] memo = new int[rows][cols];
        
        int i = 0, j = 0;
        while (i < rows && j < cols && memo[i][j] == 0) {
            for (; j < cols && memo[i][j] == 0; ++j) {
                res.add(matrix[i][j]);
                memo[i][j] = 1;
            }
            j--;
            i = i + 1;
            for (; i < rows && memo[i][j] == 0; ++i) {
                res.add(matrix[i][j]);
                memo[i][j] = 1;
            }
            i--;
            j = j - 1;
            for (; j >= 0 && memo[i][j] == 0; --j) {
                res.add(matrix[i][j]);
                memo[i][j] = 1;
            }
            j++;
            i = i - 1;
            for (; i >= 0 && memo[i][j] == 0; --i) {
                res.add(matrix[i][j]);
                memo[i][j] = 1;                
            }
            i++;
            j = j + 1;
        }
        
        return res;
        
    }
}