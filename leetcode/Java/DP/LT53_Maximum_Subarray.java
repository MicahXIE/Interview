class Solution {  // 1ms 76.16% *
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        int begin = 0;
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > dp[i -1] + nums[i]) {
                begin = i;
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}