class Solution {
    public int lengthOfLIS(int[] nums) {   // 9ms 73.91% time O(n^2) space O(n)
        if (nums == null || nums.length == 0) return 0;
            
        int[] dp = new int[nums.length];
        int len = nums.length;
        int maxans = 1;
        dp[0] = 1;
        
        for (int i = 1; i < len; ++i) {
            int maxval = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        
        return maxans;
        
    }
}