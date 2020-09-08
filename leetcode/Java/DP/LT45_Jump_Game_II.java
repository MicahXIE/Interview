/*
class Solution { // Time Limit Exceeded time O(n2) space O(n)
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (j + nums[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
*/

class Solution {    // 354ms 15.77%
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums[i]; j > 0; --j) {
                if (i + j > nums.length - 1 || dp[i + j] < dp[i] + 1) continue;  // consider  i + j == nums.length - 1
                dp[i + j] = dp[i] + 1;
            }
        }
        return dp[nums.length - 1];
    }
}

