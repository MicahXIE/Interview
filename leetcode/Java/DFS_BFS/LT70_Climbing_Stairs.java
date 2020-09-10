public class Solution { // 0ms 100%
    public int climbStairs(int n) {
        int[] memo = new int[n]; // maximum n steps
        return dfs(0, n, memo);
    }
    private int dfs(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;
        
        if (memo[i] != 0) return memo[i]; // must have
        
        return memo[i] = dfs(i + 1, n, memo) + dfs(i + 2, n, memo);
    }

}