class Solution {  // 0ms 100% time O(n) space O(1)
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; ++i) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }   
        }
        for (int j = count; j < length; ++j) {
            nums[j] = 0;
        }
    }
}