// typecal example for greedy and dynamical programming
// [1, 7, 9, 10] k = 18 Greedy (10, 7, 1) DP (9, 9)
class Solution {  // 11ms 88.47% time O(mn) space O(m)
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;  // good idea
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);   
                }
            }    
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}