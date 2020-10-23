class Solution {
    
    public int findTargetSumWays(int[] nums, int S) { // 524ms 12.49% time O(n^2) space O(n^2)
        return dfs(nums, 0, S, 0);
    }
    
    private int dfs(int[] nums, int sum, int target, int k) {
        if (nums.length == k) {
            return sum == target ? 1 : 0;
        }
        return dfs(nums, sum + nums[k], target, k + 1) + 
                dfs(nums, sum - nums[k], target, k + 1);
    } 
}