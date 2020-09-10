class Solution { // 0ms 100%
    public void sortColors(int[] nums) {
        int rflag = 0, bflag = nums.length - 1;
        for (int i = 0; i <= bflag; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, rflag++);
            }
            if (nums[i] == 2) {
                swap(nums, i--, bflag--);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}