class Solution {	//5ms 74.55%
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        if (m * n == 0)
            return m + n;
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i)
            dp[i][0] = i;
        for (int j = 0; j <= n; ++j)
            dp[0][j] = j;
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1];
                
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    replace += 1;
                
                dp[i][j] = Math.min(replace, Math.min(insert, delete));      
            }
        }
        
        return dp[m][n];
    }
}