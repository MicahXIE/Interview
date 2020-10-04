class Solution { // 1ms 100% time O(nlogn) + O(n) space O(1)
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        int count = 1;
        boolean flag = false;
        if (nums[nums.length - 1] == 0) return -1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == 0) continue;
            
            if (nums[i] >= count) {
                flag = true;
                count++;
            } else {
                if (nums[i] >= count - 1)
                    return -1;
                else
                    return count - 1;
            }
        }
        
        return flag ? count - 1 : -1;
    }
}