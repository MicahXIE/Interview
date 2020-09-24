// very smart way to reduce space complexity to O(n)
// scan every row and use prev, dp[j] to store previous value;
// origin dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1 for matrix[i - 1][j - 1] = '1'

public class Solution { // 3ms 99.23% time O(mn) space O(n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        
        int temp = 0, prev = 0;
        int max = 0;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j - 1], Math.min(prev, dp[j])) + 1;
                    max = Math.max(max, dp[j]);
                } else
                    dp[j] = 0;
                prev = temp;
            }
        }
        return max * max;

    }
}