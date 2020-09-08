class Solution { // 1ms 99.96% time O(1) space O(n)
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int steps = 0;
        int near = 0;
        int far = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > near) {
                ++steps;
                near = far;
            }
            far = Math.max(far, nums[i] + i);
        }
        return steps;
    }
}
