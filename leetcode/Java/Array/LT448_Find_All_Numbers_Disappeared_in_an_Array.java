class Solution { // 5ms 82.77% time O(n) space O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        
        for (int i : nums) {
            i = i > 0 ? i : -i;
            nums[i - 1] = nums[i - 1] > 0 ? -nums[i - 1] : nums[i - 1];
        }
        
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) 
                res.add(i + 1);
        }
        
        return res;
    }

}