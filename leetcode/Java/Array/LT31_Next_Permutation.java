class Solution {  // 0ms 100% time O(n) space O(1)
    public void nextPermutation(int[] nums) {
        // boolean isAccending = true;
        int i = nums.length - 2;
        int prev = nums.length - 1;
        int pos = nums.length - 1;
        for (; i >= 0; --i) {
            if (nums[i] < nums[prev]) {
                // isAccending = false;
                pos = findMin(nums, i);
                swap(nums, i, pos);
                break;

            } else {
                prev = i;
            }
        }
        
        // if (isAccending) {
        //     for (int i = 0; i < nums.length / 2; i++) {
        //         swap(nums, i, nums.length - i - 1);
        //     }
        // }
        // Arrays.sort(nums, i + 1, nums.length);  // slow
        reverse(nums, i + 1);
        
        return;
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int findMin(int[] nums, int i) {
        int k = nums.length - 1;
        for (; k > i; --k) {
            if (nums[k] > nums[i])
                return k;
        }
        return k;
        
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
}