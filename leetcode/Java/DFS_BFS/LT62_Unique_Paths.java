class Solution {  // 0ms 100%
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        int [][] dp = new int[m][n];
        return dfs(m, n, 0, 0, dp);
    }
    private int dfs(int m, int n, int x, int y, int[][] dp) {
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        
        if (dp[x][y] == 0) {
            dp[x][y] = dfs(m, n, x + 1, y, dp) + dfs(m, n, x, y + 1, dp);
        }
        
        return dp[x][y];
    }
}