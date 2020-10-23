class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {   // 15ms 65.14% time time O(n^2) space O(n^2) 
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (S > sum || S < -sum)
            return 0;
        
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        
        int left = 0;
        int right = 2 * sum;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = left; j <= right; ++j) {
                if (j + nums[i - 1] <= right)
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if (j - nums[i - 1] >= left)
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        
        return dp[nums.length][sum + S];
    }

}