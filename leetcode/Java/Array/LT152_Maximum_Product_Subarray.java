class Solution {  // 1ms 91.52%
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        
        for (int i = 1; i < nums.length; ++i) {
            int mx = max;
            int mn = min;
            max = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mn));
            min = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mn));
            res = Math.max(res, max);
        }
        
        return res;
    }
}