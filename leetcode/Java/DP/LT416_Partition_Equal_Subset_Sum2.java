// knapsack 01 problem optimize in space complexity

class Solution {  // 19ms 63.66% time O(mn) space O(n)
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) return false;
        sum /= 2;
        
        // reuse previous row dp array
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for (int num : nums) {
            for (int i = sum; i >0 ; --i) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        
        return dp[sum];
        
        
    }
}