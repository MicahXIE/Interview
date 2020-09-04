class Solution { // 0ms 100%
    public int[] searchRange(int[] nums, int target) {
        return new int[] {BinarySearch(nums, target, true), BinarySearch(nums, target, false)};
    }
    
    private int BinarySearch(int[] nums, int target, boolean firstOrLast) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (firstOrLast) {
                if (nums[mid] >= target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] <= target) left = mid + 1;
                else right = mid - 1;
            }
            if (nums[mid] == target) res = mid;
        }       
        return res;
    }
}