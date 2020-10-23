// knapsack 01 Problem
// 对于F(i,c)，有两种情况，将第i个物品加入和直接忽略第i个物品
// dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];

class Solution {  // 74ms 14.67% time O(mn) space O(mn)
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) return false;
        sum /= 2;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        
        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; ++j) {
            dp[0][j] = false;
        }
        
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
        
        
    }
}