class Solution {  // 1ms 95.32%
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        
        if (sum % k != 0 || sum / k < maxNum) return false;
        
        return dfs(nums, k, sum / k, new boolean[nums.length], 0, 0);
    }
    
    private boolean dfs(int[] nums, int k, int targetSum, boolean[] visited, int curSum, int nextIndex) {
        if (k == 1) return true; // k == 1 means already all k subset found
        
        if (curSum > targetSum) return false;
        
        if (curSum == targetSum) {
            return dfs(nums, k - 1, targetSum, visited, 0, 0);
        }
        
        for (int i = nextIndex; i < nums.length; ++i) {
            if (!visited[i] && curSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (dfs(nums, k, targetSum, visited, curSum + nums[i], i + 1)) {
                    return true;   
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
}