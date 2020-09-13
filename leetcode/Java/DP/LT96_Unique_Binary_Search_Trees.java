// reference https://blog.csdn.net/mine_song/article/details/70552503
// n >= 2 F(n)=F(i-1)*F(n-i) 1 <= i <= n

class Solution { // 0ms 100%
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}